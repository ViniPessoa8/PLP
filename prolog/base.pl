% Fatos

darth_vader.
padme.
luke.
leia.
ray.
shmi.
yoda.
darth_sidious.

feminino(leia).
feminino(ray).
feminino(padme).
feminino(shmi).

masculino(darth_vader).
masculino(luke).
masculino(yoda).
masculino(darth_sidious).

% Hierarquia

pai(darth_vader, luke).
pai(darth_vader, leia).
pai(padme, luke).
pai(padme, leia).
pai(shmi, darth_vader).
pai(luke, rey).

% Força

lightside(yoda).
lightside(leia).
lightside(rey).
lightside(padme).
lightside(shmi).
lightside(luke).

darkside(darth_sidious).
darkside(darth_vader).

trocou(darth_vader).

skywalker(luke).
skywalker(darth_vader).
skywalker(leia).
skywalker(rey).

jedi(yoda).
jedi(luke).

sith(darth_vader).
sith(darth_sidious).

mestre(yoda, luke).
mestre(darth_sidious, darth_vader).

matou(darth_vader, darth_sidious).
matou(darth_sidious, darth_vader).
matou(yoda, yoda).

% Regras

pai(A, B) :-
    masculino(A),
    pai(A, B).

mae(A, B) :-
    feminino(A),
    pai(A, B).

avo(A, B) :-
    pai(A, X),
    pai(X, B);
	mae(A, X),
    mae(X, B).

tio(T, A) :-
    masculino(T),
    irmaos(T, X),
    pai(X, A).

tia(T, A) :-
    feminino(T),
    irmaos(T, X),
    pai(X, A).

irmaos(X, Y) :-
    pai(Z, X),
    pai(Z, Y),
    X\=Y.