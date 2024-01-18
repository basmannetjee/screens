package Screens;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

/**
    * Constructs a new screen.
    */
@Environment(EnvType.CLIENT)
public class basmannetjeeeScreen extends Screen {
    public basmannetjeeeScreen() {
        super(Text.literal("Screen 2"));
    }

    public ButtonWidget button1;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.literal("First button"), button -> {
        })
                .dimensions(width / 2 - 205, 20, 200, 20) // The size and position of the button
                .tooltip(Tooltip.of(Text.literal("Button widget"))) // Tooltip you see when you hover over a button
                .build();

        addDrawableChild(button1); // Actually add it to the screen
    }
}