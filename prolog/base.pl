% Fatos

forca.
darth_vader.
padme.
luke.
leia.
rey.
shmi.
yoda.
darth_sidious.

feminino(leia).
feminino(rey).
feminino(padme).
feminino(shmi).

masculino(darth_vader).
masculino(luke).
masculino(yoda).
masculino(darth_sidious).

% Hierarquia

gerou(shmi, darth_vader).
gerou(darth_vader, luke).
gerou(darth_vader, leia).
gerou(padme, luke).
gerou(padme, leia).

% Força

lightside(yoda).
lightside(leia).
lightside(rey).
lightside(luke).

darkside(darth_sidious).
darkside(darth_vader).

trocou(darth_vader).

novato(forca).
padawan(forca).
cavaleiro_jedi(forca).
mestre_jedi(luke).
mestre_conselheiro(forca).
grao_mestre(yoda).

lacaio(forca).
novico(forca).
guerreiro(forca).
lorde_sith(darth_vader).
lorde_sombrio(darth_sidious).

mestre(yoda, luke).
mestre(darth_sidious, darth_vader).

jedi(yoda).
jedi(luke).

sith(darth_vader).
sith(darth_sidious).

matou(darth_vader, darth_sidious).
matou(darth_sidious, darth_vader).
matou(yoda, yoda).
matou(luke,padme).
matou(leia,padme).

% Regras
pai(A, B) :-
    masculino(A),
    gerou(A, B).

mae(A, B) :-
    feminino(A),
    gerou(A, B).

avo(A, B) :-
    gerou(A, X),
    gerou(X, B);
	mae(A, X),
    mae(X, B).

tio(T, A) :-
    masculino(T),
    irmaos(T, X),
    gerou(X, A).

tia(T, A) :-
    feminino(T),
    irmaos(T, X),
    gerou(X, A).

irmaos(X, Y) :-
    gerou(Z, X),
    gerou(Z, Y),
    X\=Y.