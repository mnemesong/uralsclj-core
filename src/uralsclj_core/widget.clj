(ns uralsclj-core.widget
  (:require [clojure.spec.alpha :as s]))

(defmulti html-process (fn [type val] type))
(defmulti js-process (fn [type val] type))
(defmulti css-process (fn [type val] type))

(defn source? [x] (or (string? x) (coll? x)))
(defn engine? [multimethod val] 
  (and (keyword? val) 
       (keys (methods multimethod))))

(s/def ::html source?)
(s/def ::js source?)
(s/def ::css source?)
(s/def ::html-engine keyword?)
(s/def ::css-engine keyword?)
(s/def ::js-engine keyword?)
(s/def ::dsl 
  (s/keys :opt-un [::html ::js ::css ::html-engine ::css-engine ::js-engine]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
