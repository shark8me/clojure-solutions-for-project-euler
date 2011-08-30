(ns roman
  (:use clojure.test))

(def romanarr [['I	'II	'III	'IV	'V	'VI	'VII	'VIII	'IX],
  ['X	'XX	'XXX	'XL	'L	'LX	'LXX	'LXXX	'XC],
  ['C	'CC	'CCC	'CD	'D	'DC	'DCC	'DCCC	'CM],
  ['M 'MM 'MMM]])

(defn numsplit [num]
     (map #(. Integer parseInt %) (rest (seq (. (str num) split ""))))
     
(defn cvt [num]
           (let [nums (numsplit num)
                 len (count nums)]
                 (map #((romanarr (first %)) (dec (second %)))
                 (map #(list %1 %2) (range (dec len) -1 -1) nums))))

(is (= 'I (cvt 1)))
(is (= 'X (cvt 10)))
(is (= 'XI (cvt 11)))

(def romanarr2 [["M" "MM" "MMM"],
        ["C" "CC"	"CCC"	"CD" "D" "DC" "DCC"	"DCCC"	"CM"],
        ["X"	"XX"	"XXX"	"XL"	"L"	"LX"	"LXX"	"LXXX"	"XC"],
        ["I"	"II"	"III"	"IV"	"V"	"VI"	"VII"	"VIII"	"IX"]])

(defn split-digits [num]
              (reverse (loop [no num arr []]
                (let [divisor (int (/ no 10))
                      remainder (rem no 10)
                      newarr (conj arr (rem no 10))]
                (if (> divisor 0)
                  (recur divisor newarr)
                  newarr)))))

(defn cvt2 [num]
   (mapcat #((romanarr2 (first %)) (second %)) 
              (map #(list %1 %2) (range 10) (map dec (split-digits num)))))
