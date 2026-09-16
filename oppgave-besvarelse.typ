#set page(
    paper: "a4",
)

#set text(
    lang: "no",
    size: 12pt,
)

#set par(
    leading: 0.75em
)

#show heading.where(level: 1): it => {
  set text(
    fill: black,
    size: 1.5em,
  )
  set par(leading: 0.4em)
  
  block(
    above: 2em,
    below: 1em,
    it
    )
}

#show heading.where(level: 2): it => {
  set text(
    fill: black,
    size: 1.25em,
  )
  set par(leading: 0.4em)
  
  block(
    above: 1.5em,
    below: 0.8em,
    it
  )
}

= dat108-innlevering-2

== *Medlemer*
- *Daniel Aarsand*
- *Bartosz Arkadiusz Paszkiewicz*
- *Jason Arrey*

