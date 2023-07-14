(ns uralsclj-core.widget
  (:require [clojure.spec.alpha :as s]))

(defn source? [x] (or (string? x) (coll? x)))

(s/def ::html source?)
(s/def ::js source?)
(s/def ::css source?)
(s/def ::html-engine string?)
(s/def ::css-engine string?)
(s/def ::js-engine string?)
(s/def ::dsl 
  (s/keys :opt [::html ::js ::css ::html-engine ::css-engine ::js-engine]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
