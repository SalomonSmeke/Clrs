# ColorGenAPI
A pallete generation device :O
####What the f*** is this?
Glad you asked, this thing makes colors.
If youve ever used a Random object in Java, you will be instantly familiar with how to work these 8 algorithms (5, really... but 3 are reversible!).

You make an instance of whatever algorithm you want out of the following:
<pre>
linearCGen
pureCGen
shadesCGen
----------------
bridgeCGen
neighborsCGen**
</pre>

Then you ask it for colors:
<pre>
Gen.nextColors();
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
These arent random colors, you set many of the variables that these use to generate colors. If you recall. I placed a separator between these algoritms, this is because they can be split into two categories (indeed, they are in the code):
<pre>
SinglePointGenerators
DualPointGenerators
</pre>
The difference is how many colors they use as input to generate the pallete.
#####Single Point Generators:
<pre>
linearCGen
pureCGen
shadesCGen
</pre>
Use a single hex value to create a pallete. Each has the following parameters you can edit:
<pre>
SinglePointGenerator.setBase Base color - The color which the alg uses to create the pallete. {default = ffffff}
SinglePointGenerator.setSteps Amount of steps - The intervals of colors generated. {default = 5, minimum = 2}
SinglePointGenerator.setEditable Editable value - The value (RGB) around which the algoritm operates. {default = dominant value}
SinglePointGenerator.setHarshness - The value (float %) that tells the algorithm how far from the original color it is allowed to go.
</pre>
They also have similarly named getters.

These generators, are equipped with two methods to generate colors each.<br>
<b>linearCGen</b>
linear, takes a color. and reduces one of its RGB values in a way that it seeks another color.<br>
reversed linear, increases the value.<br>
<b>pureCGen</b>
pure, takes a color. and reduces other values to "purify" the dominant RGB value.<br>
reverse pure, increases them<br>
<b>shadesCGen</b>
shades, takes a color. and reduces its values by percent to create darker shades (note: not just "adding black")<br>
reverse shades, increases them (whiter)<br>
<br>
these are called:
<pre>
SinglePointGenerator.nextColors()
SinglePointGenerator.nextColorsR()
</pre>

#####Dual Point Generators:
<pre>
bridgeCGen
neighborsCGen**
</pre>
Use two hex values to create a pallete. Each has the following parameters you can edit:
<pre>
DualPointGenerator.setBases Base colors - The colors which the alg uses to create the pallete. {default = [aa56ff, ba55dd]}
DualPointGenerator.setSteps Amount of steps - The intervals of colors generated. {default = 5, minimum = 2}
</pre>
Same deal, there are also getters.

These generators, are equipped with one method to generate colors each.<br>
<b>bridgeCGen</b>
bridge, takes two colors. and generates colors between them using their differences.<br>
<b>neighborsCGen</b>
neighboars, takes two colors. and generates colors around them that have the same differences those two have.<br>

**WARNING neighbors is DANGEROUS as of now. it generates as many colors as it needs to reach illegal values on both ends. Input numbers such as [ffffff]and[fffffe] and you will get 255 intervals.

####Other things:
You should look at the code, because things are more detailed there... but.
Each of these keeps a record of colors they have made. You can access them individually, or all of them.
Each of these has an overriden .toString. Printing the variable name will print the colors.
You may use this for whatever you like, provided you:
a) link to a website that implements this: www.placeholder.com (ill update this later)
b) somewhere in your source (perhaps when you instantiate this) include a comment //Color generation by Salomon Smeke. A cool dude.
c) if you are releasing the program using this publicly. Credit me somewhere? Doesnt matter where.
