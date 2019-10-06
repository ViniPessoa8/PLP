-module(main).

-export([start/0, runner/2, lap/1]).

runner(Name, PID_lap) -> runner(Name, 1, 0, PID_lap).

runner(Name, 11, Time, _) -> io:format("~s finished with ~p seconds!~n", [Name, Time]);

runner(Name, Lap, Time, PID_lap) ->
    Num = rand:uniform(7),
    timer:sleep(Num*1000),
    PID_lap ! {self(), Name, Lap, Num},

    receive
        go -> runner(Name, Lap + 1, Time + Num, PID_lap)
    end.

lap(First) ->
    if
        First ->
            PID_lap = self(),
            spawn(main, runner, ["João", PID_lap]),
            spawn(main, runner, ["Maria", PID_lap]),
            spawn(main, runner, ["Felipe", PID_lap]),
            spawn(main, runner, ["Carlos", PID_lap]),
            spawn(main, runner, ["Daniela", PID_lap]);
        true -> ok
    end,

    [
        receive {PID1, Name1, Lap1, Num1} -> io:format("~s finished the lap ~p with ~p seconds~n", [Name1, Lap1, Num1]) end,
        receive {PID2, Name2, Lap2, Num2} -> io:format("~s finished the lap ~p with ~p seconds~n", [Name2, Lap2, Num2]) end,
        receive {PID3, Name3, Lap3, Num3} -> io:format("~s finished the lap ~p with ~p seconds~n", [Name3, Lap3, Num3]) end,
        receive {PID4, Name4, Lap4, Num4} -> io:format("~s finished the lap ~p with ~p seconds~n", [Name4, Lap4, Num4]) end,
        receive {PID5, Name5, Lap5, Num5} -> io:format("~s finished the lap ~p with ~p seconds~n", [Name5, Lap5, Num5]) end
    ],
    io:format("~n"),

    PID1 ! go, PID2 ! go, PID3 ! go, PID4 ! go, PID5 ! go,
    lap(false).

start() -> spawn(main, lap, [true]).