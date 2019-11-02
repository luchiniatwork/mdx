(ns mdx.core
  (:require [cljs-node-io.core :as io]
            [markdown-it :as md-it]
            [markdown-it-include :as md-it-inc]
            [markdown-it-headinganchor :as md-it-ha]
            [markdown-it-plantuml :as md-it-puml]
            [markdown-it-container :as md-it-cont]
            [markdown-it-footnote :as md-it-foot]))

(def include-regex #"(?i)\[!include\]\(\s*(.+?)\s*\)") ;; [!include](path)

(defn ^:export init []
  #_(let [md (md-it)]
      (println (.render md "# Title\n\nParagraph."))))


(defn parse-fn [state start-line end-line silent]
  (println :start :parse-fn)
  (println start-line end-line)
  (cljs.pprint/pprint (js->clj state))
  (println (.-lineMax state))
  (println :end :parse-fn)
  #_(println (-> state .-src))
  #_(println "principio")
  false)

;; TBD this is the right one:
#_(re-seq #"(?sm)\!(.+?)\s*(\(.*?\)){0,1}\n```.*?\n(.*?)\n```" s)
;; group 1: plugin
;; group 2: inline params (with \(\))
;; group 3: content


(defn my-plugin [md opts]
  (let [ruler (-> md .-block .-ruler)]
    (.before ruler
             "fence"
             "my-plugin"
             parse-fn)))

(let [md (doto (md-it #js {:linkify true})
           #_(.use md-it-foot)
           (.use md-it-cont "warning")
           (.use md-it-puml)
           (.use md-it-ha)
           (.use md-it-inc #js {:includeRe include-regex})
           (.use my-plugin))]
  (println "\n\n\nstart")
  (let [parsed (.parse md (io/slurp "simple-test.md"))]
    #_(doseq [t parsed]
        (println "type" (.-type t)
                 "content" (.-content t))))
  
  #_(println (.render md (io/slurp "simple-test.md")))
  
  
  )
