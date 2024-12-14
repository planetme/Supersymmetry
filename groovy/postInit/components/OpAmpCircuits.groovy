def ASSEMBLER = recipemap('assembler')
def VACUUM = recipemap('vacuum_chamber')
def CIRCUIT_ASSEMBLER = recipemap('circuit_assembler')

//Change transistor to use silicon wafer instead of silicon plate
// Transistor * 8
mods.gregtech.assembler.removeByInput(120, [metaitem('plateSilicon'), metaitem('wireFineTin') * 6], [fluid('plastic') * 144])

ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineTin') * 6)
        .inputs(metaitem('wafer.silicon'))
        .fluidInputs(fluid('plastic') * 144)
        .outputs(metaitem('component.transistor') * 8)
        .duration(160)
        .EUt(120)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineGold') * 6)
        .inputs(ore('componentCapacitor'))
        .inputs(ore('componentResistor') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('componentDiode') * 2)
        .inputs(metaitem('board.phenolic'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('op_amp'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineGold') * 6)
        .inputs(ore('componentCapacitor'))
        .inputs(ore('componentResistor') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('componentDiode') * 2)
        .inputs(metaitem('board.phenolic'))
        .fluidInputs(fluid('tin') * 144)
        .outputs(metaitem('op_amp'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineGold') * 3)
        .inputs(ore('componentCapacitor'))
        .inputs(ore('componentResistor') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('componentDiode') * 2)
        .inputs(ore('foilEpoxyCresolNovolacs'))
        .fluidInputs(fluid('silicone_rubber') * 72)
        .outputs(metaitem('op_amp') * 4)
        .duration(100)
        .EUt(30)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('plateAluminium') * 2)
        .circuitMeta(5)
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('heat_sink'))
        .duration(200)
        .EUt(30)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('wafer.n_doped.silicon'))
        .fluidInputs(fluid('plastic') * 144)
        .outputs(metaitem('zener_diode') * 16)
        .duration(300)
        .EUt(30)
        .buildAndRegister()

ASSEMBLER.recipeBuilder()
        .inputs(ore('dustAcidWashedSiliconDioxide'))
        .inputs(ore('wireFineSilver'))
        .inputs(ore('wireFineAnnealedCopper') * 2)
        .fluidInputs(fluid('plastic') * 36)
        .outputs(metaitem('fuse.hv'))
        .duration(100)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('componentCapacitor') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('wireFineGold') * 6)
        .inputs(ore('componentResistor') * 6)
        .inputs(metaitem('protector_chip'))
        .inputs(metaitem('board.plastic'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('voltage_regulator.hv.unsealed'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('componentCapacitor') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('wireFineGold') * 6)
        .inputs(ore('componentResistor') * 6)
        .inputs(metaitem('protector_chip'))
        .inputs(metaitem('board.plastic'))
        .fluidInputs(fluid('tin') * 144)
        .outputs(metaitem('voltage_regulator.hv.unsealed'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('componentCapacitor') * 2)
        .inputs(ore('componentTransistor') * 4)
        .inputs(ore('wireFineGold') * 3)
        .inputs(ore('componentResistor') * 6)
        .inputs(metaitem('protector_chip'))
        .inputs(ore('plateEpoxyCresolNovolacs'))
        .fluidInputs(fluid('silicone_rubber') * 72)
        .outputs(metaitem('voltage_regulator.hv.unsealed') * 2)
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('componentTransistor') * 2)
        .inputs(metaitem("op_amp"))
        .inputs(ore('wireFineGold') * 2)
        .inputs(metaitem('zener_diode'))
        .inputs(metaitem('circuit_board.good'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('voltage_regulator.mv'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('componentTransistor') * 2)
        .inputs(metaitem("op_amp"))
        .inputs(ore('wireFineGold') * 2)
        .inputs(metaitem('zener_diode'))
        .inputs(metaitem('circuit_board.good'))
        .fluidInputs(fluid('tin') * 144)
        .outputs(metaitem('voltage_regulator.mv'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('componentTransistor') * 2)
        .inputs(metaitem("op_amp"))
        .inputs(ore('wireFineGold') * 2)
        .inputs(metaitem('zener_diode'))
        .inputs(ore('plateEpoxyCresolNovolacs'))
        .fluidInputs(fluid('silicone_rubber') * 144)
        .outputs(metaitem('voltage_regulator.mv') * 2)
        .duration(400)
        .EUt(30)
        .buildAndRegister()

VACUUM.recipeBuilder()
        .inputs(metaitem('voltage_regulator.hv.unsealed'))
        .inputs(ore('wireFineAluminium') * 4)
        .fluidInputs(fluid('plastic') * 144)
        .outputs(metaitem('voltage_regulator.hv'))
        .duration(200)
        .EUt(64)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineAluminium') * 2)
        .inputs(metaitem('heat_sink') * 2)
        .inputs(ore('componentCapacitor') * 2)
        .inputs(metaitem('fuse.hv'))
        .inputs(metaitem('zener_diode'))
        .inputs(metaitem('circuit_board.good'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('protector_chip'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineAluminium') * 2)
        .inputs(metaitem('heat_sink') * 2)
        .inputs(ore('componentCapacitor') * 2)
        .inputs(metaitem('fuse.hv'))
        .inputs(metaitem('zener_diode'))
        .inputs(metaitem('circuit_board.good'))
        .fluidInputs(fluid('tin') * 144)
        .outputs(metaitem('protector_chip'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(ore('wireFineAluminium') * 2)
        .inputs(metaitem('heat_sink') * 1)
        .inputs(ore('componentCapacitor') * 2)
        .inputs(metaitem('fuse.hv'))
        .inputs(metaitem('zener_diode'))
        .fluidInputs(fluid('silicone_rubber') * 72)
        .outputs(metaitem('protector_chip'))
        .duration(400)
        .EUt(30)
        .buildAndRegister()

// Integrated Logic Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(16, [metaitem('circuit_board.basic'), metaitem('plate.integrated_logic_circuit'), metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2], [fluid('tin') * 144])

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(metaitem('circuit_board.basic'), metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineCopper') * 2, metaitem('boltTin') * 2)
        .inputs(metaitem('op_amp'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('circuit.basic_integrated') * 6)
        .duration(200)
        .EUt(16)
        .buildAndRegister()

// Good Integrated Circuit * 2
mods.gregtech.circuit_assembler.removeByInput(24, [metaitem('circuit_board.good'), metaitem('circuit.basic_integrated') * 2, metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineGold') * 4, metaitem('boltSilver') * 4], [fluid('soldering_alloy') * 72])
mods.gregtech.circuit_assembler.removeByInput(24, [metaitem('circuit_board.good'), metaitem('circuit.basic_integrated') * 2, metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineGold') * 4, metaitem('boltSilver') * 4], [fluid('tin') * 144])

CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(metaitem('circuit.basic_integrated') * 2, metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('wireFineAnnealedCopper') * 4)
        .inputs(metaitem('voltage_regulator.mv'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('circuit.good_integrated') * 2)
        .duration(400)
        .EUt(24)
        .buildAndRegister()

// Advanced Integrated Circuit * 1
mods.gregtech.circuit_assembler.removeByInput(30, [metaitem('circuit.good_integrated') * 2, metaitem('plate.integrated_logic_circuit') * 2, metaitem('plate.random_access_memory') * 2, metaitem('component.transistor') * 4, metaitem('wireFineElectrum') * 8, metaitem('boltAnnealedCopper') * 8], [fluid('soldering_alloy') * 72])
mods.gregtech.circuit_assembler.removeByInput(30, [metaitem('circuit.good_integrated') * 2, metaitem('plate.integrated_logic_circuit') * 2, metaitem('plate.random_access_memory') * 2, metaitem('component.transistor') * 4, metaitem('wireFineElectrum') * 8, metaitem('boltAnnealedCopper') * 8], [fluid('tin') * 144])


CIRCUIT_ASSEMBLER.recipeBuilder()
        .inputs(metaitem('circuit.good_integrated') * 2, metaitem('component.resistor') * 2, metaitem('component.diode') * 2, metaitem('boltElectrum') * 8)
        .inputs(metaitem('voltage_regulator.hv'))
        .fluidInputs(fluid('soldering_alloy') * 72)
        .outputs(metaitem('circuit.advanced_integrated') * 2)
        .duration(800)
        .EUt(30)
        .buildAndRegister()