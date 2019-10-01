(defun elementos(num lista)
    (princ (nth (- num 1) lista))
)

(defun main()
    (let ((lista (list 11 23 32 47 54 62 71 82 96 10)))
    (elementos (read) lista)
    )
)