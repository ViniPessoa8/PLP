-module(q2).

-export([start/0]).

menor(A, B) ->
    case A < B of
      true -> [A];
      false -> [B]
    end.

start() ->
    {ok, A} = io:read("Enter A: "),
    {ok, B} = io:read("Enter B: "),
    io:fwrite("~w~n", menor(A, B)).
