(ns notebook.fibonacci)

; infinite seq
(def fib-seq-seq
  ((fn fib [a b]
     (lazy-seq (cons a (fib b (+ a b)))))
   0 1))

(take 20 fib-seq-seq)

