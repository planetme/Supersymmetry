import globals.Globals

MIXER = recipemap('mixer')
SINTERING_OVEN = recipemap('sintering_oven')
BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
ROASTER = recipemap('roaster')
DISTILLERY = recipemap('distillery')
DT = recipemap('distillation_tower')
DRYER = recipemap('dryer')
AUTOCLAVE = recipemap('autoclave')
ION_EXCHANGE = recipemap('ion_exchange_column')
FBR = recipemap('fixed_bed_reactor')
LCR = recipemap('large_chemical_reactor')

// Alumina supports

MIXER.recipeBuilder()
    .inputs(ore('dustAmmoniumHexachloroplatinate') * 17)
    .fluidInputs(fluid('phosphoric_acid') * 1000)
    .fluidOutputs(fluid('platinum_precursor_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('dustAlumina') * 5)
    .fluidInputs(fluid('platinum_precursor_solution') * 1000)
    .outputs(metaitem('dustSupportedPlatinum'))
    .fluidOutputs(fluid('phosphoric_acid') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustPalladiumChloride') * 3)
    .fluidInputs(fluid('phosphoric_acid') * 1000)
    .fluidOutputs(fluid('palladium_precursor_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('dustAlumina') * 5)
    .fluidInputs(fluid('palladium_precursor_solution') * 1000)
    .outputs(metaitem('dustSupportedPalladium'))
    .fluidOutputs(fluid('phosphoric_acid') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[3])
    .buildAndRegister()

SINTERING_OVEN.recipeBuilder()
    .inputs(ore('dustAlumina') * 5)
    .fluidInputs(fluid('nickel_nitrate_solution') * 1000)
    .outputs(metaitem('dustSupportedNickel'))
    .fluidOutputs(fluid('dense_steam') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustSupportedNickel'))
    .fluidInputs(fluid('hydrogen_sulfide') * 100)
    .outputs(metaitem('dustHydrotreatingCatalyst'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Tungsten source

ROASTER.recipeBuilder()
    .inputs(ore('dustAmmoniumParatungstate'))
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('ammonium_metatungstate_solution') * 4000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('ammonium_metatungstate_solution') * 4000)
    .outputs(metaitem('dustAmmoniumMetatungstate'))
    .fluidOutputs(fluid('ammonia_solution') * 4000)
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Isomerization catalysts

BR.recipeBuilder()
    .inputs(ore('dustSupportedPlatinum') * 5)
    .fluidInputs(fluid('hydrogen_chloride') * 100)
    .outputs(metaitem('dustChloridedAlumina'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustZirconiumDioxide') * 3)
    .inputs(ore('dustAmmoniumHexachloroplatinate'))
    .fluidInputs(fluid('aluminium_sulfate_solution') * 6000)
    .outputs(metaitem('dustSulfatedMetalOxide'))
    .duration(100)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

// Zeolites

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_silicate_solution') * 1000)
    .outputs(metaitem('dustSodiumSilicate') * 6)
    .fluidOutputs(fluid('water') * 1000)
    .duration(20)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .fluidInputs(fluid('dense_steam') * 1000)
    .inputs(ore('dustSiliconDioxide') * 3)
    .fluidOutputs(fluid('diluted_sodium_silicate_solution') * 4000)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('sodium_aluminate_solution') * 1500)
    .fluidOutputs(fluid('water') * 1500)
    .outputs(metaitem('dustSodiumAluminate') * 4)
    .duration(160)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
    .inputs(ore('dustAnyPurityAluminium') * 2)
    .fluidOutputs(fluid('hydrogen') * 6000)
    .outputs(metaitem('dustSodiumAluminate') * 8)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

// Type X zeolite (molecular sieve, 9 angstrom)

AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('diluted_sodium_silicate_solution') * 4000)
    .inputs(ore('dustSodiumAluminate') * 4)
    .fluidOutputs(fluid('type_x_zeolite_solution') * 4000)
    .duration(180)
    .EUt(30)
    .buildAndRegister()

AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('sodium_silicate_solution') * 1000)
    .fluidInputs(fluid('distilled_water') * 3000)
    .inputs(ore('dustSodiumAluminate') * 4)
    .fluidOutputs(fluid('type_x_zeolite_solution') * 4000)
    .duration(180)
    .EUt(30)
    .buildAndRegister()

DT.recipeBuilder()
    .fluidInputs(fluid('diluted_sodium_silicate_solution') * 1000)
    .fluidOutputs(fluid('water') * 750)
    .fluidOutputs(fluid('sodium_silicate_solution') * 250)
    .duration(200)
    .EUt(30)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('type_x_zeolite_solution') * 4000)
    .outputs(metaitem('dustTypeXZeolite'))
    .fluidOutputs(fluid('dense_steam') * 4000)
    .duration(400)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustTypeXZeolite'))
    .inputs(ore('dustClay'))
    .outputs(metaitem('dustMolecularSieve'))
    .duration(180)
    .EUt(30)
    .buildAndRegister()

// Type Y zeolite (FCC catalyst)

AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('diluted_sodium_silicate_solution') * 8000)
    .fluidInputs(fluid('tetramethylammonium_hydroxide_solution') * 1000)
    .inputs(ore('dustSodiumAluminate') * 4)
    .fluidOutputs(fluid('type_y_zeolite_solution') * 9000)
    .duration(180)
    .EUt(30)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('type_y_zeolite_solution') * 9000)
    .outputs(metaitem('dustTypeYZeolite'))
    .duration(100)
    .EUt(60)
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustTypeYZeolite'))
    .inputs(ore('dustClay'))
    .fluidInputs(fluid('ammonium_chloride_solution') * 1000)
    .outputs(metaitem('cracking_catalyst'))
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(100)
    .EUt(60)
    .buildAndRegister()

// ZSM-5

FBR.recipeBuilder()
    .notConsumable(metaitem('catalystBedAlumina'))
    .fluidInputs(fluid('ammonia') * 50)
    .fluidInputs(fluid('n_propanol') * 150)
    .fluidOutputs(fluid('tripropylamine') * 50)
    .fluidOutputs(fluid('water') * 150)
    .duration(5)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .notConsumable(metaitem('emitter.lv'))
    .notConsumable(fluid('hydrogen_peroxide_solution') * 50)
    .fluidInputs(fluid('hydrobromic_acid') * 1000)
    .fluidInputs(fluid('propene') * 1000)
    .fluidOutputs(fluid('n_bromopropane') * 1000)
    .fluidOutputs(fluid('water') * 1000)
    .duration(5)
    .EUt(120)
    .buildAndRegister();

BR.recipeBuilder()
    .fluidInputs(fluid('n_bromopropane') * 1000)
    .fluidInputs(fluid('tripropylamine') * 1000)
    .outputs(metaitem('dustTetrapropylammoniumBromide'))
    .duration(5)
    .EUt(120)
    .buildAndRegister();

LCR.recipeBuilder()
    .inputs(ore('dustSiliconDioxide') * 6)
    .inputs(ore('dustAluminiumSulfate') * 51)
    .inputs(ore('dustSodiumHydroxide'))
    .inputs(ore('dustTinyTetrapropylammoniumBromide'))
    .fluidInputs(fluid('ethanol') * 100)
    .fluidInputs(fluid('demineralized_water') * 1800)
    .outputs(metaitem('dustZsmFive'))
    .duration(500)
    .EUt(480)
    .buildAndRegister();

// Olefin condensation catalysts

    // SHOP process catalyst

    BR.recipeBuilder()
        .inputs(ore('dustNickelIiOxide') * 2)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('nickel_nitrate_solution') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('nickel_nitrate_solution') * 1000)
        .outputs(metaitem('dustNickelIiNitrate') * 9)
        .fluidOutputs(fluid('water') * 1000)
        .duration(20)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustNickelIiNitrate') * 9)
        .fluidInputs(fluid('acetylacetone') * 2000)
        .fluidInputs(fluid('sodium_hydroxide_solution') * 2000)
        .fluidOutputs(fluid('nickel_ii_bisacetylacetonate_solution') * 2000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .fluidInputs(fluid('nickel_ii_bisacetylacetonate_solution') * 2000)
        .outputs(metaitem('dustNickelIiBisacetylacetonate'))
        .outputs(metaitem('dustSodiumNitrate') * 10)
        .fluidOutputs(fluid('dense_steam') * 2000)
        .duration(120)
        .EUt(480)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustNickelIiBisacetylacetonate'))
        .fluidInputs(fluid('cyclooctadiene') * 2000)
        .fluidInputs(fluid('triethylaluminium') * 2000)
        .outputs(metaitem('dustBiscyclooctadienenickelZero'))
        .fluidOutputs(fluid('ethane') * 1000)
        .fluidOutputs(fluid('ethylene') * 1000)
        .fluidOutputs(fluid('diethylaluminium_acetylacetonate') * 2000)
        .duration(120)
        .EUt(30)
        .buildAndRegister()

    BR.recipeBuilder()
        .fluidInputs(fluid('diethylaluminium_acetylacetonate') * 1000)
        .fluidInputs(fluid('hydrochloric_acid') * 3000)
        .fluidOutputs(fluid('aluminium_chloride_solution') * 3000)
        .fluidOutputs(fluid('acetylacetone') * 1000)
        .fluidOutputs(fluid('ethylene') * 2000)
        .duration(160)
        .EUt(30)
        .buildAndRegister()

    DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('aluminium_chloride_solution') * 3000)
        .outputs(metaitem('dustAluminiumChloride') * 4)
        .fluidOutputs(fluid('water') * 3000)
        .EUt(Globals.voltAmps[1])
        .duration(20)
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustTriphenylphosphine'))
        .fluidInputs(fluid('phosphorus_trichloride') * 500)
        .fluidOutputs(fluid('chlorodiphenylphosphine') * 1500)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    CSTR.recipeBuilder()
        .fluidInputs(fluid('chlorodiphenylphosphine') * 50)
        .fluidInputs(fluid('acetic_acid') * 50)
        .notConsumable(fluid('sodium_hydroxide_solution') * 50)
        .fluidOutputs(fluid('diphenylphosphinoacetic_acid') * 50)
        .duration(10)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustBiscyclooctadienenickelZero'))
        .fluidInputs(fluid('diphenylphosphinoacetic_acid') * 1000)
        .fluidInputs(fluid('ethylene_glycol') * 1000)
        .fluidOutputs(fluid('shell_higher_olefin_catalyst_solution') * 1000)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

    // SPA catalysts for gasoline polymerate

    MIXER.recipeBuilder()
        .inputs(ore('dustDiatomite'))
        .fluidInputs(fluid('phosphoric_acid') * 1700)
        .outputs(metaitem('dustWetSolidPhosphoricAcid'))
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()
        
    DRYER.recipeBuilder()
        .inputs(ore('dustWetSolidPhosphoricAcid'))
        .outputs(metaitem('dustSolidPhosphoricAcid'))
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    // Hydrocracking catalyst

    AUTOCLAVE.recipeBuilder()
        .fluidInputs(fluid('sodium_silicate_solution') * 1000)
        .fluidInputs(fluid('aluminium_sulfate_solution') * 100)
        .outputs(metaitem('dustAmorphousSilicaAlumina'))
        .fluidOutputs(fluid('wastewater') * 1100)
        .duration(200)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    BR.recipeBuilder()
        .inputs(ore('dustCobaltOxide') * 2)
        .fluidInputs(fluid('nitric_acid') * 2000)
        .fluidOutputs(fluid('cobalt_nitrate_solution') * 1000)
        .duration(60)
        .EUt(Globals.voltAmps[1])
        .buildAndRegister()

    ROASTER.recipeBuilder()
        .inputs(ore('dustAmorphousSilicaAlumina') * 10)
        .inputs(ore('dustAmmoniumMetatungstate'))
        .fluidInputs(fluid('cobalt_nitrate_solution') * 2000)
        .outputs(metaitem('hydrocracking_catalyst') * 10)
        .duration(200)
        .EUt(Globals.voltAmps[3])
        .buildAndRegister()

// HZSM-5

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