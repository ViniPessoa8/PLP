(defun primo(n)
    (if (<= n 1) (return-from primo nil))
    (loop for i from 2 to n
        do (if (eq (mod n i) 0)
            (return-from primo nil)
            (return-from primo t)
        )
    )
)

(defun main()
    (princ (primo (read)))
    (fresh-line)
)