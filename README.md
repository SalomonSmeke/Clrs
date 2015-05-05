# ColorGenAPI
A palette generation device :O
####What the f*** is this?
Glad you asked, this thing makes colors.
If you've ever used a Random object in Java, you will be instantly familiar with how to work these 7 algorithms (4, really... but 3 are reversible!).

You make an instance of whatever algorithm you want out of the following:
<pre>
LinearGen
DistillGen
ShadeGen
----------------
BridgeGen
</pre>

Then you ask it for colors:
<pre>
CGen.nextColors();
</pre>

This will create HEX colors that go nicely with the base color (we will get to that):
<pre>
ffffff
cccccc
999999
666666
333333
000000
</pre>

#####You have control:
These aren't random colors, you set many of the variables that these use to generate colors. If you recall; I placed a separator between these algorithms, this is because they can be split into two categories (indeed, they are in the code):
<pre>
onePointGenerators
twoPointGenerators
</pre>
The difference is how many colors they use as input to generate the palette.
#####One Point Generators:
<pre>
LinearGen
DistillGen
ShadeGen
</pre>
Use a single hex value to create a palette. Each has the following parameters you can edit:
<pre>
onePointGenerator.setBase - The color which the alg uses to create the palette. {default = ffffff}
onePointGenerator.setSteps Amount of steps - The intervals of colors generated. {default = 2, minimum = 2}
onePointGenerator.setPivot - The value (RGB) around which the algorithm operates. {default = dominant value}
onePointGenerator.setStrength - The value (float %) that tells the algorithm how far from the original color it is allowed to go.
</pre>
They also have similarly named getters.

These generators, are equipped with two methods to generate colors each.<br>
<b>LinearGen</b>
linear, takes a color. and reduces one of its RGB values in a way that it seeks another color.<br>
reversed linear, increases the value.<br>
<b>DistillGen</b>
pure, takes a color. and reduces other values to "distill" the dominant RGB value.<br>
reverse pure, increases them<br>
<b>ShadeCGen</b>
shades, takes a color. and reduces its values by percent to create darker shades (note: not just "adding black")<br>
reverse shades, increases them (whiter)<br>
<br>
these are called:
<pre>
onePointGenerator.nextColors()
onePointGenerator.nextColorsR()
</pre>

#####Two Point Generators:
<pre>
bridgeCGen
</pre>
Use two hex values to create a palette. Each has the following parameters you can edit:
<pre>
twoPointGenerator.setBases Base colors - The colors which the alg uses to create the palette. {default = [ffffff, ffffff]}
twoPointGenerator.setSteps Amount of steps - The intervals of colors generated. {default = 2, minimum = 2}
</pre>
Same deal, there are also getters.

These generators, are equipped with one method to generate colors each.<br>
<b>BridgeGen</b>
bridge, takes two colors. and generates colors between them using their differences.<br>

####Other things:
You should look at the code, because things are more detailed there... but.<br>
Each of these keeps a record of colors they have made. You can access them individually, or all of them.<br>
Each of these has an overridden .toString. Printing the variable name will print the colors.<br>
You may use this for whatever you like, provided you:<br>
a) link to a website that implements this: www.placeholder.com (ill update this later)<br>
b) somewhere in your source (perhaps when you instantiate this) include a comment //Color generation by Salomon Smeke. A cool dude.<br>
c) if you are releasing the program using this publicly. Credit me somewhere? Doesn't matter where.<br>

####Final thought:
This is definitely not a great thing. But it makes pretty cool colors. I would love pointers, etc. Feel free to fork the heck out of it.
