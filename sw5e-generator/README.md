## SW5e Module Generator

This will read the SW5e website API data and generate a Fantasy Grounds module.

#### Current state of development

__EXTREME__  early alpha.  Most things are hard-coded and sloppy.  *__I would not use this if I were you.__*

----

Currently this program does the following:
- Pickes up and filters the output from the old par5e utility.
- adds spells from sw5e json to the module xml after filtering
- adds equipment from sw5e json to the module xml after filtering
- adds parcels for starting equipment from above equipment to the xml
- has a spell actions section that will insert/replace effects coding into spell xml output
