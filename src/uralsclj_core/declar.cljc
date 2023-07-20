(ns uralsclj-core.declar
  (:require [clojure.spec.alpha :as s]
            [clojure.string :as str]
            [uralsclj-core.model :as m]))

(s/def ::name string?)
(s/def ::template string?)
(s/def ::init coll?)
(s/def ::host string?)
(s/def ::t 
  (s/keys :req-un [::name ::template ::init ::host]))

(defn valid? [x] (s/valid? ::t x))