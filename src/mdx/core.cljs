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


(let [md (doto (md-it #js {:linkify true})
           #_(.use md-it-foot)
           (.use md-it-cont "warning")
           (.use md-it-puml)
           (.use md-it-ha)
           (.use md-it-inc #js {:includeRe include-regex}))]
  (let [parsed (.parse md (io/slurp "simple-test.md"))]
    (cljs.pprint/pprint (js->clj parsed))

    (doseq [t parsed]
      (println "type" (.-type t)
               "content" (.-content t))))
  
  (println (.render md (io/slurp "simple-test.md")))

  )
