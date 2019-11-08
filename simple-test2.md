# Title

Para

| First Header    | Second Header   |
| -------------   | -------------   |
| Content Cell a1 | Content Cell b1 |
| Content Cell b1 | Content Cell b2 |

::: warning
here be dragons
:::

@startuml
Bob -> Alice : hello
@enduml


---

## Including other files:

simple include:

[!include](otherfile.md)

code include:

[!include-code](file.js)

---

## Global requires:

```
!require
[{image = "my.image.url.com",
  as = "my-plugin",
  refer = ["my-fn"]},
 {image = "my.image2.url.com",
  refer = ["my-fn2"]}]
```

now we can call:

- my-fn (would run my-plugin/my-fn)
- my-fn2 (would run my-fn2 on the other image)
- my-plugin/aaa (would run aaa on my-plugin)
- my-pligin/nnn (would run nnn on my-pligin)

---

## Docinfo

```
!docinfo
{action-marker = "!",
 naming-marker = "."}
```

TBD: decide whether require could fold under docinfo

---

## Applying in-line placement on blocks:

without parameters:

`!my-plugin/my-fn`
```
code block to be sent
```

with parameters:

`!my-plugin/my-fn({param1=3,param2=4,param3=5})`

```
code block to be sent
```

with multi-line parameters:

```
!my-plugin/my-fn
{param1=3,
 param2=4,
 param3=5}
```

```
code block to be sent
```

---

## Applying in-line fact-extraction on blocks:

without parameters:

`!my-plugin/my-fn`

```
code block to be sent
```

with parameters:

`!my-plugin/my-fn({param1=3,param2=4,param3=5})`

```
code block to be sent
```

with multi-line parameters:

```
!my-plugin/my-fn
{param1=3,
 param2=4,
 param3=5}
```
```
code block to be sent
```

---

## Naming blocks:

ex1 (code block):

`.code-name-A This code is dope`

```
target code here
```

ex2 (other sort of blocks - table i.e.):

`.my-table-name This table is awesome`

| First Header    | Second Header   |
| -------------   | -------------   |
| Content Cell a1 | Content Cell b1 |
| Content Cell b1 | Content Cell b2 |

ex3 (description is optional):

`.a-table`

| First Header    | Second Header   |
| -------------   | -------------   |
| Content Cell a1 | Content Cell b1 |
| Content Cell b1 | Content Cell b2 |

---

## Applying referenced placement on blocks:

without parameters:

`!my-plugin/my-fn:code-name-A`

with parameters:

`!my-plugin/my-fn:code-name-A({param1=3,param2=4,param3=5})`

with multi-line parameters:

```
!my-plugin/my-fn:code-name-A
{param1=3,
 param2=4,
 param3=5}
```

---

## Applying referenced fact-extraction on blocks:

same as above
