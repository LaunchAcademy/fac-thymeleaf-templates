## Before the Session

- Review user stories supplied with this codebase
- Review the controller and the views 
- Note: `trains/index.html` includes the layout (fulfilling the last requirement, while the `show.html` has been left to not consider the layout)
- Once, you're comfortable with what's happening in the views, delete them, including the layout

## During the Session

### Take the Students on a Tour of the Codebase

- Note the `pom.xml` and the dependencies listed there
- Start up a server showing that it is a Spring Boot application

### Take Them Through the Controller

#### Show

- The `show` handler is straightforward - there's a predefined list of trains. We add 1 to the index to find the train with the specified "id"
- Note the annotation around the `@PathParam` and the syntax of the `@GetMapping` with the curly braces to emphasize the dynamic nature of the url
- The interesting part here is how we handle when the train id is not found. We throw an exception that is wired into Spring in a way that results in a 404 status code

#### Index

- The `index` handler is equally straightforward - just note that we assign two ui.Model attributes and subsequently render the view

### Implement the Show View

- `xmlns:th="http://www.thymeleaf.org"` is an XML namespace - recall that XML and HTML are close siblings. This is our way of instructing the document to use an additional set of rules. Everything this a `th:` prefix is governed by this namespace.

### Implement the Index View

- Use the `th:text` attribute to output the station
- Use the `th:each` to iterate through all of the trains
- Use a `th:style` to assign the color
- Use a ternary operation in the loop to apply bold styling to Thomas
- We should caveat that while this is convenient, we'd typically want to set semantic classes instead of inline styles

### Add the Layout

- This is the tricky part. I would practice this one prior to doing it live
- Define a layout in `src/main/resources/templates/fragments` as `layout.html`
- `th:fragment` is like saying you can invoke this view like a function, with `template` being an argument
- We use `th:block` `th:include` to basically inject the argument where we want it to go
- It's worth noting that Thymeleaf's templating engine is very capable and very complicated. It has a reputation as one of the more complex templating languages out there
- In the individual views, we can set `th:replace="~{fragments/layout :: layout (~{::body})}"` on the `html` tag. This is complex, but it basically means:
  - We're going to use `fragments/layout` template. We're passing the `body` of this template in as the `template` argument to the layout.
- Implement in both views - make a small change to the layout and demonstrate how it affects both pages
- share that this is a very trivial example, but for more complicated layouts you can start to imagine the possiblities