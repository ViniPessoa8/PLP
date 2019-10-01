-module(q1).

-export([start/0]).

soma(A, B) -> [A + B].

start() ->
    {ok, A} = io:read("Enter A: "),
    {ok, B} = io:read("Enter B: "),
    io:fwrite("~w~n", soma(A, B)).
