(ns uralsclj-core.widget
  (:require [clojure.spec.alpha :as s]))

(defmulti engine-process (fn [type val] type))

(defn source? [x] (or (string? x) (coll? x)))
(defn engine? [multimethod val] 
  (and (keyword? val) 
       (keys (methods multimethod))))

(s/def ::html source?)
(s/def ::js source?)
(s/def ::css source?)
(s/def ::engine #(or (keyword? %) (string? %)))
(s/def ::dsl 
  (s/keys :opt-un [::html ::js ::css ::engine]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
