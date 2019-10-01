-module(q5).

-export([start/0]).

leitura() -> string:equal(io:get_line("True or False?: "), "True\n").

check(A, B, C) -> [A and B and C].

start() ->
    A = leitura(),
    B = leitura(),
    C = leitura(),
    io:fwrite("~w~n", check(A, B, C)).
