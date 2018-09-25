# PixelPainter
A paint application in console.


## Prerequisites
 - Java 1.8
 - Maven

### Assumptions
- All the values are assumed to be non-zero positive.

## Steps to run Pixel painter - a painter in console
### To run from IDE
- Import the project as maven project.
- Build and run the project as java application.

### To run from cmd
From the root folder that has pom.xml
- run `mvn package`
- run `mvn package spring-boot:repackage`
- run `mvn spring-boot:run`

## Commands 

> ==============================================================================================
> | Command        | Description                                                               |
> ==============================================================================================
> | C w h         | Should create a new canvas of width w and height h.                        |
> ----------------------------------------------------------------------------------------------
> | L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Currently only           |
> |               | horizontal or vertical lines are supported. Horizontal and vertical lines  |
> |               | will be drawn using the 'x' character.                                     |
> ----------------------------------------------------------------------------------------------
> | R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and      |
> |               | lower right corner is (x2,y2). Horizontal and vertical lines will be drawn |
> |               | using the 'x' character.                                                   |
> ----------------------------------------------------------------------------------------------
> | B x y c       | Should fill the entire area connected to (x,y) with "colour" c. The        |
> |               | behaviour of this is the same as that of the "bucket fill" tool in paint   |
> |               | programs.                                                                  |
> ----------------------------------------------------------------------------------------------
> | E             | Erase created canvas. Basically re-creates it.                             |
> ----------------------------------------------------------------------------------------------
> | Q             | Should quit the program.                                                   |
> ==============================================================================================
