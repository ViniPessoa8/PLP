-module(q3).

-export([start/0]).

menor(A, B, C) ->
    Return = if
        (A < B) and (A < C) -> [A];
        (B < A) and (B < C) -> [B];
        true -> [C]
    end,
    Return.

start() ->
    {ok, A} = io:read("Enter A: "),
    {ok, B} = io:read("Enter B: "),
    {ok, C} = io:read("Enter C: "),
    io:fwrite("~w~n", menor(A, B, C)).
