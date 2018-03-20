clj -Sdeps '{:deps {pack/pack.alpha {:git/url "https://github.com/juxt/pack.alpha.git" :sha "eed89476315661e2389d5d078ec17375bec3efa5"}}}' -m mach.pack.alpha.jcl deps.edn app.jar build_dir
