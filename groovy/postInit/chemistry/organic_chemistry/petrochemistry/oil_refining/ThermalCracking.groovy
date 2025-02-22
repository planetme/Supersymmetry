import globals.Globals
import static globals.Petrochemistry.*

CRACKER = recipemap('cracker')
DT = recipemap('distillation_tower')
COKING = recipemap('coking_tower')
TUBE_FURNACE = recipemap('tube_furnace')
FLBR = recipemap('fluidized_bed_reactor')
PHASE_SEPARATOR = recipemap('phase_separator')

// Thermal Cracking
crackables.each { _, crackable -> 
    if (crackable.thermal_crackable) {
        ROASTER.recipeBuilder()
            .fluidInputs(crackable.get(1000))
            .fluidOutputs(crackable.getThermallyCracked(700))
            .duration(800)
            .EUt(Globals.voltAmps[2])
            .buildAndRegister()

        CRACKER.recipeBuilder()
            .fluidInputs(crackable.get(4000))
            .fluidOutputs(crackable.getThermallyCracked(4000))
            .circuitMeta(1)
            .duration(200)
            .EUt(Globals.voltAmps[2] * 2)
            .buildAndRegister()

        // Visbreaking
        MIXER.recipeBuilder()
            .fluidInputs(crackable.getThermallyCracked(250))
            .fluidInputs(crackable.get(600))
            .fluidInputs(fractions.heavy_gas_oil.getCrude(150))
            .fluidOutputs(crackable.getQuenched(1000))
            .duration(40)
            .EUt(30)
            .buildAndRegister()
    }
}

// Visbreaking Separation 
    DT.recipeBuilder()
        .fluidInputs(crackables.atmospheric_oil_residue.getQuenched(1000))
        .fluidOutputs(fluid('visbreaking_residue') * 550)
        .fluidOutputs(fractions.heavy_gas_oil.getCrude(150))
        .fluidOutputs(fractions.light_gas_oil.getCrude(300))
        .fluidOutputs(fractions.naphtha.getCrude(385))
        .fluidOutputs(fluid('sulfuric_fuel_gas') * 275)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

    DT.recipeBuilder()
        .fluidInputs(crackables.vacuum_oil_residue.getQuenched(1000))
        .fluidOutputs(fluid('visbreaking_residue') * 645)
        .fluidOutputs(fractions.heavy_gas_oil.getCrude(150))
        .fluidOutputs(fractions.light_gas_oil.getCrude(355))
        .fluidOutputs(fractions.naphtha.getCrude(305))
        .fluidOutputs(fluid('sulfuric_fuel_gas') * 225)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

// Coking
    // Delayed Coking
        VACUUM_DT.recipeBuilder()
            .fluidInputs(crackables.atmospheric_oil_residue.get(1000))
            .fluidInputs(fluid('coking_effluents') * 470)
            .fluidOutputs(fluid('coking_residue') * 470)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(325))
            .fluidOutputs(fractions.light_gas_oil.getCrude(225))
            .fluidOutputs(fractions.naphtha.getCrude(1560))
            .fluidOutputs(fluid('sulfuric_fuel_gas') * 1365)
            .circuitMeta(2)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        VACUUM_DT.recipeBuilder()
            .fluidInputs(crackables.vacuum_oil_residue.get(890))
            .fluidInputs(fluid('coking_effluents') * 470)
            .fluidOutputs(fluid('coking_residue') * 470)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(325))
            .fluidOutputs(fractions.light_gas_oil.getCrude(225))
            .fluidOutputs(fractions.naphtha.getCrude(1560))
            .fluidOutputs(fluid('sulfuric_fuel_gas') * 1365)
            .circuitMeta(2)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        VACUUM_DT.recipeBuilder()
            .fluidInputs(fluid('clarified_slurry_oil') * 1000)
            .fluidInputs(fluid('coking_effluents') * 470)
            .fluidOutputs(fluid('coking_residue') * 470)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(325))
            .fluidOutputs(fractions.light_gas_oil.getCrude(225))
            .fluidOutputs(fractions.naphtha.getCrude(1560))
            .fluidOutputs(fluid('sulfuric_fuel_gas') * 1365)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        VACUUM_DT.recipeBuilder()
            .fluidInputs(fluid('visbreaking_residue') * 850)
            .fluidInputs(fluid('coking_effluents') * 470)
            .fluidOutputs(fluid('coking_residue') * 470)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(325))
            .fluidOutputs(fractions.light_gas_oil.getCrude(225))
            .fluidOutputs(fractions.naphtha.getCrude(1560))
            .fluidOutputs(fluid('sulfuric_fuel_gas') * 1365)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        TUBE_FURNACE.recipeBuilder()
            .fluidInputs(fluid('coking_residue') * 1000)
            .fluidOutputs(fluid('heated_coking_residue') * 1000)
            .duration(50)
            .EUt(480)
            .buildAndRegister()

        TUBE_FURNACE.recipeBuilder() // Startup
            .fluidInputs(crackables.atmospheric_oil_residue.get(1000))
            .fluidOutputs(fluid('heated_coking_residue') * 1000)
            .duration(1000)
            .EUt(480)
            .buildAndRegister()

        COKING.recipeBuilder()
            .fluidInputs(fluid('heated_coking_residue') * 1000)
            .fluidInputs(fluid('water') * 1000)
            .outputs(metaitem('dustGreenCoke') * 32)
            .fluidOutputs(fluid('coking_effluents') * 1000)
            .duration(50)
            .EUt(30)
            .buildAndRegister()
            
    // Fluid Coking
        FLBR.recipeBuilder()
            .fluidInputs(crackables.atmospheric_oil_residue.get(1125))
            .inputs(ore('dustHeatedGreenCoke') * 4)
            .fluidOutputs(fluid('coke_fines') * 1000)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        FLBR.recipeBuilder()
            .fluidInputs(crackables.vacuum_oil_residue.get(1000))
            .inputs(ore('dustHeatedGreenCoke') * 4)
            .fluidOutputs(fluid('coke_fines') * 1000)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        FLBR.recipeBuilder()
            .fluidInputs(fluid('clarified_slurry_oil') * 1125)
            .inputs(ore('dustHeatedGreenCoke') * 4)
            .fluidOutputs(fluid('coke_fines') * 1000)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        FLBR.recipeBuilder()
            .fluidInputs(fluid('visbreaking_residue') * 960)
            .inputs(ore('dustHeatedGreenCoke') * 4)
            .fluidOutputs(fluid('coke_fines') * 1000)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

        PHASE_SEPARATOR.recipeBuilder()
            .fluidInputs(fluid('coke_fines') * 1000)
            .outputs(metaitem('dustGreenCoke') * 20)
            .fluidOutputs(fluid('fluid_cracked_vacuum_oil_residue') * 1000)
            .duration(10)
            .buildAndRegister()

        DT.recipeBuilder()
            .fluidInputs(fluid('fluid_cracked_vacuum_oil_residue') * 1000)
            .fluidOutputs(fractions.heavy_gas_oil.getCrude(360))
            .fluidOutputs(fractions.light_gas_oil.getCrude(540))
            .fluidOutputs(fractions.naphtha.getCrude(1150))
            .fluidOutputs(fluid('sulfuric_fuel_gas') * 1580)
            .duration(50)
            .EUt(30)
            .buildAndRegister()

    // Flexicoking
        PYROLYSE_OVEN.recipeBuilder()
            .inputs(ore('dustGreenCoke') * 20)
            .fluidInputs(fluid('dense_steam') * 16000)
            .outputs(metaitem('dustHeatedGreenCoke') * 4)
            .fluidOutputs(fluid('syngas') * 12000)
            .duration(50)
            .EUt(30)
            .buildAndRegister()