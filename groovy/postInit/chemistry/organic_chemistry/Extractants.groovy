import static globals.Globals.*

CSTR = recipemap('continuous_stirred_tank_reactor')
TBR = recipemap('trickle_bed_reactor')
FBR = recipemap('fixed_bed_reactor')
BCR = recipemap('bubble_column_reactor')
BR = recipemap('batch_reactor')
POLYMERIZATION = recipemap('polymerization_tank')
FLUIDIZEDBR = recipemap('fluidized_bed_reactor')
DISTILLATION_TOWER = recipemap('distillation_tower')
DISTILLERY = recipemap('distillery')
ROASTER = recipemap('roaster')
CRYSTALLIZER = recipemap('crystallizer')
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
CHEMICAL_BATH = recipemap('chemical_bath')
CENTRIFUGE = recipemap('centrifuge')
PYROLYSE = recipemap('pyrolyse_oven')
LCR = recipemap('large_chemical_reactor')
EBF = recipemap('electric_blast_furnace')
VULCANIZER = recipemap('vulcanizing_press')
ALLOY_SMELTER = recipemap('alloy_smelter')
ARC_FURNACE = recipemap('arc_furnace')
VACUUM_DT = recipemap('vacuum_distillation')
AUTOCLAVE = recipemap('autoclave')
COMPRESSOR = recipemap('compressor')
ASSEMBLER = recipemap('assembler')
ELECTROLYZER = recipemap('electrolyzer')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
REACTION_FURNACE = recipemap('reaction_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
PSA = recipemap('pressure_swing_adsorption')
SINTERING_OVEN = recipemap('sintering_oven')

//LIXIVANTS
//SODIUM CYANIDE
BCR.recipeBuilder()
    .fluidInputs(fluid('sodium_hydroxide_solution') * 50)
    .fluidInputs(fluid('gtfo_hydrogen_cyanide') * 50)
    .fluidOutputs(fluid('sodium_cyanide_solution') * 100)
    .duration(10)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_cyanide_solution') * 2000)
    .outputs(metaitem('dustSodiumCyanide') * 3)
    .fluidOutputs(fluid('water') * 2000)
    .duration(60)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//Frank-Caro process
EBF.recipeBuilder()
    .inputs(ore('dustCalciumCarbide') * 3)
    .fluidInputs(fluid('nitrogen') * 2000)
    .outputs(metaitem('dustCalciumCyanamide') * 4)
    .outputs(metaitem('dustCarbon'))
    .blastFurnaceTemp(1200)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCalciumCyanamide') * 4)
    .inputs(ore('dustCarbon'))
    .fluidInputs(fluid('salt') * 576)
    .outputs(metaitem('dustSodiumCyanide') * 6)
    .outputs(metaitem('dustCalciumChloride') * 3)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustCalciumCyanamide') * 4)
    .fluidInputs(fluid('water') * 3000)
    .outputs(metaitem('dustCalcite') * 5)
    .fluidOutputs(fluid('ammonia') * 200)
    .duration(200)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//SODIUM THIOSULFATE
BCR.recipeBuilder() 
    .fluidInputs(fluid('soda_ash_solution') * 50)
    .fluidInputs(fluid('sulfur_dioxide') * 50)
    .fluidOutputs(fluid('sodium_sulfite_solution') * 50)
    .fluidOutputs(fluid('carbon_dioxide') * 50)
    .duration(6)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustSulfur'))
    .fluidInputs(fluid('sodium_sulfite_solution') * 1000)
    .fluidOutputs(fluid('sodium_thiosulfate_solution') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DISTILLERY.recipeBuilder() 
    .fluidInputs(fluid('sodium_thiosulfate_solution') * 1000)
    .outputs(metaitem('dustSodiumThiosulfate') * 7)
    .fluidOutputs(fluid('water') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//FLOTATION AGENTS
//FATTY ACIDS
ROASTER.recipeBuilder()
    .fluidInputs(fluid('steam') * 3000)
    .fluidInputs(fluid('seed_oil') * 1000)
    .fluidOutputs(fluid('glycerol') * 1000)
    .fluidOutputs(fluid('fatty_acid_solution') * 3000)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('fatty_acid_solution') * 1000)
    .fluidInputs(fluid('methanol') * 1000)
    .inputs(ore('dustUrea'))
    .fluidOutputs(fluid('oleic_acid_solution') * 1000)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('oleic_acid_solution') * 1000)
    .outputs(metaitem('dustOleicAcid') * 18)
    .fluidOutputs(fluid('methanol') * 1000)
    .EUt(30)
    .duration(200)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .inputs(ore('dustOleicAcid') * 18)
    .fluidOutputs(fluid('alkaline_sodium_oleate_solution') * 1000)
    .EUt(30)
    .duration(80)
    .buildAndRegister()

//XANTHATES
//SODIUM ETHYL XANTHATE
BR.recipeBuilder()
    .inputs(ore('dustSodium'))
    .fluidInputs(fluid('ethanol') * 2000)
    .fluidOutputs(fluid('hydrogen') * 1000)
    .fluidOutputs(fluid('sodium_ethoxide_solution') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

/*CSTR.recipeBuilder()
    .fluidInputs(fluid('sodium_ethoxide_solution') * 50)
    .fluidInputs(fluid('carbon_disulfide') * 50)
    .fluidOutputs(fluid('sodium_ethyl_xanthate_solution') * 50)
    .EUt(Globals.voltAmps[3])
    .duration(4)
    .buildAndRegister()*/

BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 3)
        .fluidInputs(fluid('ethanol') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidOutputs(fluid('sodium_ethyl_xanthate_solution') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('sodium_ethyl_xanthate_solution') * 1000)
        .outputs(metaitem('dustSodiumEthylXanthate'))
        .fluidOutputs(fluid('water') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//POTASSIUM ETHYL XANTHATE

BR.recipeBuilder()
        .inputs(ore('dustPotassiumHydroxide') * 3)
        .fluidInputs(fluid('ethanol') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidOutputs(fluid('potassium_ethyl_xanthate_solution') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_ethyl_xanthate_solution') * 1000)
        .outputs(metaitem('dustPotassiumEthylXanthate'))
        .fluidOutputs(fluid('water') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//POTASSIUM BUTYL XANTHATE
BR.recipeBuilder()
        .inputs(ore('dustPotassiumHydroxide') * 3)
        .fluidInputs(fluid('n_butanol') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidOutputs(fluid('potassium_butyl_xanthate_solution') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_butyl_xanthate_solution') * 1000)
        .outputs(metaitem('dustPotassiumButylXanthate'))
        .fluidOutputs(fluid('water') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//POTASSIUM AMYL XANTHATE
REACTION_FURNACE.recipeBuilder()
        .inputs(metaitem('dustDicobaltOctacarbonyl') * 18)
        .fluidInputs(fluid('hot_hp_hydrogen') * 2000)
        .fluidInputs(fluid('carbon_monoxide') * 1000)
        .fluidInputs(fluid('one_butene') * 1000)
        .fluidOutputs(fluid('pentanal_mixture') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('pentanal_mixture') * 1000)
        .outputs(metaitem('dustDicobaltOctacarbonyl') * 18)
        .fluidOutputs(fluid('valeraldehyde') * 800)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

FBR.recipeBuilder()
        .fluidInputs(fluid('valeraldehyde') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .notConsumable(metaitem('susy:hv_catalyst_bed_reduction'))
        .fluidOutputs(fluid('n_pentanol') * 50)
        .EUt(Globals.voltAmps[3])
        .duration(4)
        .buildAndRegister()

FBR.recipeBuilder()
        .fluidInputs(fluid('valeraldehyde') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .notConsumable(metaitem('catalystBedPlatinum'))
        .fluidOutputs(fluid('n_pentanol') * 50)
        .EUt(Globals.voltAmps[3])
        .duration(4)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustPotassiumHydroxide') * 3)
        .fluidInputs(fluid('n_pentanol') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidOutputs(fluid('potassium_amyl_xanthate_solution') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_amyl_xanthate_solution') * 1000)
        .outputs(metaitem('dustPotassiumAmylXanthate'))
        .fluidOutputs(fluid('water') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//SODIUM ISOBUTYL XANTHATE
BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 3)
        .fluidInputs(fluid('isobutyl_alcohol') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidOutputs(fluid('sodium_isobutyl_xanthate_solution') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('sodium_isobutyl_xanthate_solution') * 1000)
        .outputs(metaitem('dustSodiumIsobutylXanthate'))
        .fluidOutputs(fluid('water') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//POTASSIUM ISOPROPYL XANTHATE
BR.recipeBuilder()
        .inputs(ore('dustPotassiumHydroxide') * 3)
        .fluidInputs(fluid('isopropyl_alcohol') * 1000)
        .fluidInputs(fluid('carbon_disulfide') * 1000)
        .fluidOutputs(fluid('potassium_isopropyl_xanthate_solution') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_isopropyl_xanthate_solution') * 1000)
        .outputs(metaitem('dustPotassiumIsopropylXanthate'))
        .fluidOutputs(fluid('water') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//HEXYLAMMONIUM ACETATE
BR.recipeBuilder()
        .notConsumable(metaitem('dustActivatedRaneyNickel'))
        .fluidInputs(fluid('n_hexadecanol') * 1000)
        .fluidInputs(fluid('ammonia') * 1000)
        .outputs(metaitem('dustNHexadecylamine'))
        .fluidOutputs(fluid('water') * 1000)
        .duration(60)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustNHexadecylamine'))
        .fluidInputs(fluid('acetic_acid') * 1000)
        .outputs(metaitem('dustNHexadecylammoniumAcetate'))
        .duration(3)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//HYDROXAMATES
//OCTYL HYDROXAMATE
BR.recipeBuilder()
        .fluidInputs(fluid('octanoyl_chloride') * 1000)
        .fluidInputs(fluid('hydroxylamine') * 1000)
        .outputs(metaitem('dustOctylHydroxamicAcid'))
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustOctylHydroxamicAcid'))
        .fluidInputs(fluid('potassium_hydroxide_solution') * 1000)
        .outputs(metaitem('dustPotassiumOctylHydroxamate'))
        .fluidOutputs(fluid('water') * 2000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

//1-AMIDOETHYL-2-ALKYL-2-IMIDAZOLINE

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustDicobaltOctacarbonyl') * 18)
        .fluidInputs(fluid('hydrogen') * 2000)
        .fluidInputs(fluid('carbon_monoxide') * 1000)
        .fluidInputs(fluid('eight_twenty_olefin_mixture') * 1000)
        .fluidOutputs(fluid('nine_twenty_one_aldehyde_mixture') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('nine_twenty_one_aldehyde_mixture') * 1000)
        .fluidInputs(fluid('oxygen') * 1000)
        .fluidOutputs(fluid('nine_twenty_one_fatty_acid_mixture') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .fluidInputs(fluid('diethylenetriamine') * 1000)
        .fluidInputs(fluid('nine_twenty_one_fatty_acid_mixture') * 2000)
        .fluidOutputs(fluid('one_amidoethyl_two_alkyl_two_imidazoline') * 1000)
        .fluidOutputs(fluid('steam') * 3000)
        .EUt(Globals.voltAmps[4])
        .duration(80)
        .buildAndRegister()

//LIQUID-LIQUID EXTRACTANTS
//TODGA
CSTR.recipeBuilder()
        .fluidInputs(fluid('diethylene_glycol') * 50)
        .fluidInputs(fluid('nitric_acid') * 400)
        .fluidInputs(fluid('ethanol') * 50)
        .fluidOutputs(fluid('diglycolic_acid_solution') * 150)
        .fluidOutputs(fluid('nitrogen_dioxide') * 200)
        .duration(3)
        .EUt(120)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diglycolic_acid_solution') * 3000)
        .fluidOutputs(fluid('diglycolic_acid') * 1000)
        .fluidOutputs(fluid('water') * 1900)
        .fluidOutputs(fluid('nitric_acid') * 4000)
        .fluidOutputs(fluid('ethanol_water_azeotrope') * 1100)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('diglycolic_acid') * 50)
        .fluidInputs(fluid('thionyl_chloride') * 50)
        .fluidInputs(fluid('pyridine') * 50)
        .fluidOutputs(fluid('diluted_chloroacetic_anhydride') * 150)
        .fluidOutputs(fluid('sulfur_dioxide') * 50)
        .duration(3)
        .EUt(120)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diluted_chloroacetic_anhydride') * 3000)
        .outputs(metaitem('dustChloroaceticAnhydride') * 13)
        .fluidOutputs(fluid('pyridine') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .notConsumable(ore('catalystBedNickel'))
        .fluidInputs(fluid('n_octanol') * 50)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('n_octylamine') * 50)
        .fluidOutputs(fluid('water') * 50)
        .duration(3)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

TBR.recipeBuilder()
        .circuitMeta(2)
        .notConsumable(metaitem('dustActivatedRaneyNickel'))
        .fluidInputs(fluid('n_octanol') * 100)
        .fluidInputs(fluid('ammonia') * 100)
        .fluidOutputs(fluid('dioctylamine') * 50)
        .fluidOutputs(fluid('water') * 100)
        .duration(3)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 8)
        .fluidInputs(fluid('dioctylamine') * 2000)
        .inputs(ore('dustChloroaceticAnhydride') * 13)
        .fluidOutputs(fluid('tetraoctyl_diglycolamide') * 1000)
        .fluidOutputs(fluid('diluted_saltwater') * 2000)
        .duration(400)
        .EUt(480)
        .buildAndRegister()

//TRIOCTYLAMINE

TBR.recipeBuilder()
        .circuitMeta(1)
        .notConsumable(ore('dustNickel'))
        .fluidInputs(fluid('n_octanol') * 150)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('trioctylamine') * 50)
        .fluidOutputs(fluid('water') * 150)
        .duration(3)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

//ISODECANOL

FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedZsmFive'))
        .fluidInputs(fluid('propene') * 150)
        .fluidOutputs(fluid('tripropylene') * 50)
        .duration(5)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(metaitem('dustDicobaltOctacarbonyl') * 18)
        .fluidInputs(fluid('hot_hp_hydrogen') * 2000)
        .fluidInputs(fluid('carbon_monoxide') * 1000)
        .fluidInputs(fluid('tripropylene') * 1000)
        .fluidOutputs(fluid('isodecanal_mixture') * 1000)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('isodecanal_mixture') * 1000)
        .outputs(metaitem('dustDicobaltOctacarbonyl') * 18)
        .fluidOutputs(fluid('isodecanal') * 500)
        .EUt(Globals.voltAmps[3])
        .duration(80)
        .buildAndRegister()

FBR.recipeBuilder()
        .fluidInputs(fluid('isodecanal') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .notConsumable(metaitem('catalystBedPlatinum'))
        .fluidOutputs(fluid('isodecanol') * 50)
        .EUt(Globals.voltAmps[3])
        .duration(4)
        .buildAndRegister()

//TBP
CSTR.recipeBuilder()
        .fluidInputs(fluid('n_butanol') * 150)
        .fluidInputs(fluid('phosphoryl_chloride') * 50)
        .fluidOutputs(fluid('acidic_tributyl_phosphate') * 200)
        .duration(3)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustSodiumHydroxide') * 9)
        .fluidInputs(fluid('acidic_tributyl_phosphate') * 4000)
        .fluidOutputs(fluid('tributyl_phosphate') * 1000)
        .fluidOutputs(fluid('salt_water') * 3000)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

//D2EHPA
CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
        .fluidInputs(fluid('butyraldehyde') * 2000)
        .fluidOutputs(fluid('two_ethyl_two_hexenal') * 3000)
        .fluidOutputs(fluid('diluted_sodium_hydroxide_solution') * 1000)
        .duration(60)
        .EUt(120)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('diluted_sodium_hydroxide_solution') * 2000)
        .fluidOutputs(fluid('water') * 2000)
        .outputs(metaitem('dustSodiumHydroxide') * 4)
        .duration(100)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedCobalt'))
        .fluidInputs(fluid('two_ethyl_two_hexenal') * 100)
        .fluidInputs(fluid('hydrogen') * 200)
        .fluidOutputs(fluid('two_ethylhexanol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustPhosphorusPentoxide') * 7)
        .fluidInputs(fluid('two_ethylhexanol') * 6000)
        .fluidOutputs(fluid('two_ethylhexyl_phosphoric_acid_mix') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('two_ethylhexyl_phosphoric_acid_mix') * 2000)
        .fluidInputs(fluid('hexane') * 1000)
        .fluidOutputs(fluid('mono_two_ethylhexyl_phosphoric_acid') * 1000)
        .fluidOutputs(fluid('di_two_ethylhexyl_phosphoric_acid_solution') * 2000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('di_two_ethylhexyl_phosphoric_acid_solution') * 2000)
        .fluidOutputs(fluid('di_two_ethylhexyl_phosphoric_acid') * 1000)
        .fluidOutputs(fluid('hexane') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

//N1923
MIXER.recipeBuilder()
        .inputs(ore('dustYttriumOxide') * 5)
        .inputs(ore('dustNeodymiumOxide') * 5)
        .inputs(ore('dustPurifiedManganeseDioxide') * 3)
        .outputs(metaitem('dustRareEarthCatalystYNd') * 13)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()     

//C10 & 12 ACIDS
LCR.recipeBuilder()
        .inputs(ore('dustChromiumTrioxide') * 16)
        .fluidInputs(fluid('sulfuric_acid') * 6000)
        .fluidInputs(fluid('distilled_water') * 15000)
        .fluidInputs(fluid('acetone') * 1000)
        .fluidInputs(fluid('n_decanol') * 3000)
        .fluidOutputs(fluid('chromium_sulfate_solution') * 1000)
        .fluidOutputs(fluid('capric_acid') * 3000)
        .duration(300)
        .EUt(480)
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustChromiumTrioxide') * 16)
        .fluidInputs(fluid('sulfuric_acid') * 6000)
        .fluidInputs(fluid('acetone') * 1000)
        .fluidInputs(fluid('n_dodecanol') * 3000)
        .fluidOutputs(fluid('chromium_sulfate_solution') * 1000)
        .fluidOutputs(fluid('lauric_acid') * 3000)
        .duration(300)
        .EUt(480)
        .buildAndRegister()

LCR.recipeBuilder()
        .notConsumable(metaitem('dustRareEarthCatalystYNd'))
        .fluidInputs(fluid('lauric_acid') * 1000)
        .fluidInputs(fluid('capric_acid') * 1000)
        .fluidInputs(fluid('nitrogen') * 2000)
        .fluidOutputs(fluid('diluted_primary_amine_n') * 2000)
        .fluidOutputs(fluid('carbon_dioxide') * 3000)
        .duration(300)
        .EUt(480)
        .buildAndRegister()

VACUUM_DT.recipeBuilder()
        .fluidInputs(fluid('diluted_primary_amine_n') * 1000)
        .fluidOutputs(fluid('primary_amine_n') * 400)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

//DBC
FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedPlatinum'))
        .fluidInputs(fluid('butyraldehyde') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .fluidOutputs(fluid('n_butanol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

CSTR.recipeBuilder()
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('diethylene_glycol') * 50)
        .fluidInputs(fluid('n_butanol') * 100)
        .fluidOutputs(fluid('dibutyl_carbitol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

//TRI OCTYL DECYL AMINE
CSTR.recipeBuilder()
        .fluidInputs(fluid('hydrobromic_acid') * 50)
        .fluidInputs(fluid('n_octanol') * 50)
        .fluidOutputs(fluid('diluted_bromooctane') * 150)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('diluted_bromooctane') * 2000)
        .fluidOutputs(fluid('bromooctane') * 1000)
        .fluidOutputs(fluid('water') * 2000)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('bromooctane') * 2000)
        .inputs(ore('dustLithium'))
        .inputs(ore('dustCopper'))
        .fluidOutputs(fluid('lithium_dioctylcopper') * 1000)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('capric_acid') * 1000)
        .fluidInputs(fluid('thionyl_chloride') * 1000)
        .fluidOutputs(fluid('decanoyl_chloride') * 1000)
        .fluidOutputs(fluid('hydrogen_chloride') * 1000)
        .fluidOutputs(fluid('sulfur_dioxide') * 1000)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('lithium_dioctylcopper') * 100)
        .fluidInputs(fluid('decanoyl_chloride') * 100)
        .fluidOutputs(fluid('nine_octadecanone') * 150)
        .duration(15)
        .EUt(120)
        .buildAndRegister()

BR.recipeBuilder()
        .fluidInputs(fluid('diborane') * 500)
        .inputs(ore('dustSodiumCyanide') * 6)
        .outputs(metaitem('dustSodiumCyanoborohydride') * 14)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

LCR.recipeBuilder()
        .notConsumable(fluid('sulfuric_acid') * 1000)
        .notConsumable(metaitem('dustSodiumCyanoborohydride') * 7)
        .fluidInputs(fluid('nine_octadecanone') * 3000)
        .fluidInputs(fluid('ammonia') * 1000)
        .fluidOutputs(fluid('tri_octyl_decyl_amine') * 1000)
        .duration(300)
        .EUt(480)
        .buildAndRegister()

//ION EXCHANGE RESINS
//AG 50W-X8
POLYMERIZATION.recipeBuilder()
        .circuitMeta(1)
        .fluidInputs(fluid('polystyrene') * 1000)
        .fluidInputs(fluid('divinylbenzene') * 1000)
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidOutputs(fluid('crosslinked_polystyrene') * 1008)
        .EUt(120)
        .duration(160)
        .buildAndRegister()

CSTR.recipeBuilder()
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('ethylbenzene') * 50)
        .fluidInputs(fluid('ethylene') * 50)
        .fluidOutputs(fluid('diethylbenzene') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('roundCrosslinkedPolystyrene') * 32)
        .fluidInputs(fluid('oleum') * 1100)
        .outputs(metaitem('beads.ag_fifty_w_x_eight'))
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

FLUIDIZEDBR.recipeBuilder()
        .fluidInputs(fluid('diethylbenzene') * 1000)
        .notConsumable(ore('dustChromiumTrioxide'))
        .fluidOutputs(fluid('divinylbenzene') * 1000)
        .fluidOutputs(fluid('hydrogen') * 4000)
        .duration(300)
        .EUt(120)
        .buildAndRegister()

//AMBERLYST, MIBK, AND MIBC

POLYMERIZATION.recipeBuilder()
        .inputs(ore('dustPalladium') * 2)
        .fluidInputs(fluid('polystyrene') * 1000)
        .fluidInputs(fluid('divinylbenzene') * 1000)
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidOutputs(fluid('palladium_doped_crosslinked_polystyrene') * 1008)
        .EUt(120)
        .duration(160)
        .buildAndRegister()

CSTR.recipeBuilder()
        .notConsumable(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('ethylbenzene') * 50)
        .fluidInputs(fluid('ethylene') * 50)
        .fluidOutputs(fluid('diethylbenzene') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

CSTR.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 50)
        .fluidInputs(fluid('sulfur_trioxide') * 5)
        .fluidOutputs(fluid('oleum') * 55)
        .duration(4)
        .EUt(30)
        .buildAndRegister()

MIXER.recipeBuilder()
        .fluidInputs(fluid('sulfuric_acid') * 1000)
        .fluidInputs(fluid('sulfur_trioxide') * 100)
        .fluidOutputs(fluid('oleum') * 1100)
        .duration(80)
        .EUt(120)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('roundPalladiumDopedCrosslinkedPolystyrene') * 32)
        .fluidInputs(fluid('oleum') * 1100)
        .outputs(metaitem('beads.amberlyst_ch'))
        .fluidOutputs(fluid('sulfuric_acid') * 1000)
        .EUt(120)
        .duration(200)
        .buildAndRegister()

LCR.recipeBuilder()
        .notConsumable(metaitem('beads.amberlyst_ch'))
        .fluidInputs(fluid('acetone') * 2000)
        .fluidInputs(fluid('hot_hp_hydrogen') * 2000)
        .fluidOutputs(fluid('diluted_methyl_isobutyl_ketone') * 2000)
        .duration(300)
        .EUt(480)
        .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
        .fluidInputs(fluid('diluted_methyl_isobutyl_ketone') * 2000)
        .fluidOutputs(fluid('methyl_isobutyl_ketone') * 1000)
        .fluidOutputs(fluid('water') * 1000)
        .duration(200)
        .EUt(120)
        .buildAndRegister()

FBR.recipeBuilder()
        .notConsumable(metaitem('catalystBedCopper'))
        .fluidInputs(fluid('methyl_isobutyl_ketone') * 50)
        .fluidInputs(fluid('hydrogen') * 100)
        .fluidOutputs(fluid('methyl_isobutyl_carbinol') * 50)
        .duration(5)
        .EUt(120)
        .buildAndRegister()

//RHENIUM EXTRACTION

FBR.recipeBuilder()
        .notConsumable(ore('catalystBedAlumina'))
        .fluidInputs(fluid('n_butanol') * 50)
        .fluidInputs(fluid('ammonia') * 50)
        .fluidOutputs(fluid('n_butylamine') * 50)
        .fluidOutputs(fluid('water') * 50)
        .duration(3)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustSiliconDioxide') * 6)
        .inputs(ore('dustAluminiumSulfate') * 51)
        .inputs(ore('dustSodiumHydroxide'))
        .fluidInputs(fluid('ethanol') * 100)
        .fluidInputs(fluid('demineralized_water') * 1800)
        .fluidInputs(fluid('n_butylamine') * 100)
        .outputs(metaitem('dustHzsmFive'))
        .duration(500)
        .EUt(480)
        .buildAndRegister();

FBR.recipeBuilder()
        .notConsumable(ore('catalystBedHzsmFive'))
        .fluidInputs(fluid('toluene') * 50)
        .fluidInputs(fluid('ethylene') * 50)
        .fluidOutputs(fluid('ethyltoluene') * 50)
        .duration(5)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister();

CSTR.recipeBuilder()
        .fluidInputs(fluid('chlorine') * 50)
        .fluidInputs(fluid('ethyltoluene') * 50)
        .notConsumable(fluid('zinc_chloride_solution') * 1000)
        .notConsumable(fluid('formaldehyde') * 1000)
        .fluidOutputs(fluid('vinylbenzyl_chloride') * 50)
        .fluidOutputs(fluid('hydrogen') * 100)
        .duration(5)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister();

MIXER.recipeBuilder()
        .fluidInputs(fluid('aluminium') * 144)
        .inputs(ore('dustCobalt') * 1)
        .inputs(ore('dustTinyZinc') * 1)
        .outputs(metaitem('dustRaneyCobalt') * 2)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

BR.recipeBuilder()
        .inputs(ore('dustRaneyCobalt') * 4)
        .inputs(ore('dustSodiumHydroxide') * 6)
        .fluidInputs(fluid('water') * 6000)
        .outputs(metaitem('dustActivatedRaneyCobalt') * 2)
        .outputs(metaitem('dustSodiumAluminate') * 20)
        .fluidOutputs(fluid('hydrogen') * 6000)
        .duration(240)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

TBR.recipeBuilder()
        .fluidInputs(fluid('hydrogen') * 300)
        .fluidInputs(fluid('gtfo_aniline') * 50)
        .notConsumable(ore('dustActivatedRaneyCobalt') * 1)
        .fluidOutputs(fluid('cyclohexylamine') * 50)
        .duration(20)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

POLYMERIZATION.recipeBuilder()
        .fluidInputs(fluid('vinylbenzyl_chloride') * 100)
        .fluidInputs(fluid('polystyrene') * 1000)
        .fluidInputs(fluid('divinylbenzene') * 1000)
        .inputs(ore('dustTinyPotassiumPersulfate'))
        .fluidOutputs(fluid('functionalizable_crosslinked_polystyrene') * 1008)
        .EUt(120)
        .duration(160)
        .buildAndRegister()

CHEMICAL_BATH.recipeBuilder()
        .inputs(ore('roundFunctionalizableCrosslinkedPolystyrene') * 32)
        .fluidInputs(fluid('cyclohexylamine') * 100)
        .outputs(metaitem('beads.rhenium_ion_exchange'))
        .EUt(120)
        .duration(200)
        .buildAndRegister()