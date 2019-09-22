-module(q2).

-export([start/0]).

menor(A, B) ->
    case A < B of
      true -> io:fwrite("~w~n", [A]);
      false -> io:fwrite("~w~n", [B])
    end.

start() ->
    {ok, A} = io:read("Enter A: "),
    {ok, B} = io:read("Enter B: "),
    menor(A, B).
