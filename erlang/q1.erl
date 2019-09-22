-module(q1).

-export([start/0]).

soma(A, B) -> io:fwrite("~w~n", [A + B]).

start() ->
    {ok, A} = io:read("Enter A: "),
    {ok, B} = io:read("Enter B: "),
    soma(A, B).
