;; Observe that our model of evaluation allows for combinations whose operators are com-pound expressions.
;; Use this observation to describe the behavior of the following function:

(defn a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(a-plus-abs-b 2 3) ;; 5
(a-plus-abs-b 2 -1) ;; 3

;; The function returns an expression which, if b is greater than zero, applies the addition function to a and b
;; Otherwise, the subtract function is applied to a and b.
;; The if expression is used to decide upon and return the operator which is to be applied to the operands
