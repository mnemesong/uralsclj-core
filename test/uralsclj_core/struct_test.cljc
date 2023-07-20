(ns uralsclj-core.struct-test
  (:require [clojure.test :refer :all]
            [uralsclj-core.struct :as struct]
            [clojure.spec.alpha :as s]))

(deftest has-no-empty-prop-test
  (testing "has-no-empty-prop on not empty prop hashmap exist prop"
    (is (= true (struct/has-no-empty-prop {:html "alola"} :html))))
  (testing "has-no-empty-prop on not empty prop hashmap not exist prop"
    (is (= false (struct/has-no-empty-prop {:html "alola"} :js))))
  (testing "has-no-empty-prop on nil"
    (is (= false (struct/has-no-empty-prop {:html nil} :html))))
  (testing "has-no-empty-prop on empty string"
    (is (= false (struct/has-no-empty-prop {:html ""} :html)))))

(deftest replace-property-test 
  (testing "replace-property-test"
    (is (= {:html "Hello John!", :js "Hello {{a1}}!"}
           (struct/replace-property {
                    :html "Hello {{a1}}!" 
                    :js "Hello {{a1}}!"
                } 
                :html 
                {:a1 "John" :a2 "Mike"})))))

(deftest has-keys?-test
  (testing "has-keys on empty struct"
    (is (= false (struct/has-keys? {}))))
  (testing "has-keys without args"
    (is (= true (struct/has-keys? {:abba :djsa}))))
  (testing "has special keys 1"
    (is (= false (struct/has-keys? {:abba :djsa :uat 12} [:uur]))))
  (testing "has special keys 2"
    (is (= true (struct/has-keys? {:abba :djsa :uur 12} [:uur])))))