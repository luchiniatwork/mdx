(ns mdx.docker
  (:require [dockerode :as dockerode]))

(def docker (new dockerode))

(-> (.version docker)
    (.then (fn [result err] (cljs.pprint/pprint (js->clj result))))
    (.catch (fn [result err] (println result))))


(-> (.listImages docker)
    (.then (fn [result err] (cljs.pprint/pprint (js->clj result))))
    (.catch (fn [result err] (println result))))
