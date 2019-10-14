-module(ring).

-export([start/2]).

ring(NumProcess, NumProcess, NumLaps, First_process, Main_process) ->
    Main_process ! finished,
    First_process ! send,
    loop(NumLaps, NumProcess, NumProcess, First_process, Main_process);

ring(ActualLap, NumProcess, NumLaps, First_process, Main_process) ->
    Next_process = spawn(fun() -> ring (ActualLap + 1, NumProcess, NumLaps, First_process, Main_process) end),
    loop(NumLaps, ActualLap, NumProcess, Next_process, Main_process).


loop(0, NumProcess, NumProcess, _, Main_process) ->
    Main_process ! ended;

loop(ActualLap, I, NumProcess, Next_process, Main_process) ->
    receive
      send ->
	    Next_process ! send,
	    loop(ActualLap - 1, I, NumProcess, Next_process, Main_process)
    end.

start(NumProcess, NumLaps) ->
    statistics(runtime),

    Main_process = self(),
    spawn(fun () -> ring(1, NumProcess, NumLaps, self(), Main_process) end),

    [
        receive
            finished ->
                {_, TimeSpawn} = statistics(runtime),
                TimeEndSpawn = TimeSpawn,
                io:format("Spawn finished with: ~p milliseconds~n", [TimeEndSpawn])
        end,
        receive ended -> void end
    ],

    % receive

    %     ended ->
    %         void;
    %     finished ->
    %         io:format("uiguyvyu")
    % end,

    {_, Time} = statistics(runtime),
    TimeEnd = Time,

    io:format("~p processes and ~p laps = ~p milliseconds~n", [NumProcess, NumLaps, TimeEnd]).
