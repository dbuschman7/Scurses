addCommandAlias("fullClean", ";project scurses_root ;clean ;cleanFiles")
addCommandAlias("tc", ";test:compile")
addCommandAlias("cc", ";fullClean   ;test:compile")
addCommandAlias("ctc", ";clean  ;test:compile")
addCommandAlias("ccTest", ";cc   ;test")
addCommandAlias("to", "test-only")

addCommandAlias("scurses",";project scurses  ;ctc")
addCommandAlias("onions", ";project onions   ;ctc")

