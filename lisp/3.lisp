(defun min-tres (n1 n2 n3)
    (princ "Minimo dos 3 numeros: ")
    (princ (min n1 n2 n3))
)

(defun main ()
    (min-tres (read) (read) (read))
    (fresh-line)
)