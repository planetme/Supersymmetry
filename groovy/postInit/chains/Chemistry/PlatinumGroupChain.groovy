import static globals.Globals.*

BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
DISTILLERY = recipemap('distillery')
DISTILLATION_TOWER = recipemap('distillation_tower')
ROASTER = recipemap('roaster')
MACERATOR = recipemap('macerator')

//LOW EFFICIENCY CHAIN (66%)
BR.recipeBuilder()
    .inputs(metaitem('dustAlluvialPlatinum'))
    .fluidInputs(fluid('aqua_regia') * 8000)
    .fluidOutputs(fluid('hexachloroplatinic_acid_solution') * 1000)
    .fluidOutputs(fluid('oxygen') * 1000)
    .fluidOutputs(fluid('nitrosyl_chloride') * 1000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('hexachloroplatinic_acid_solution') * 50)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 100)
    .fluidOutputs(fluid('sodium_hexachloroplatinate_solution') * 250)
    .duration(12)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('sodium_hexachloroplatinate_solution') * 5000)
    .fluidInputs(fluid('ammonium_chloride_solution') * 3000)
    .chancedOutput(metaitem('dustAmmoniumHexachloroplatinate') * 17, 6667, 0)
    .fluidOutputs(fluid('diluted_ammonium_chloride_solution') * 8000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('diluted_ammonium_chloride_solution') * 8000)
    .fluidOutputs(fluid('ammonium_chloride_solution') * 1000)
    .fluidOutputs(fluid('water') * 7000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLERY.recipeBuilder()
    .fluidInputs(fluid('diluted_ammonium_chloride_solution') * 8000)
    .outputs(metaitem('dustAmmoniumChloride') * 6)
    .fluidOutputs(fluid('water') * 8000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(metaitem('dustAmmoniumHexachloroplatinate') * 17)
    .fluidInputs(fluid('hydrogen') * 4000)
    .outputs(metaitem('sponge.platinum'))
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(metaitem('sponge.platinum'))
    .outputs(metaitem('dustPlatinum'))
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()