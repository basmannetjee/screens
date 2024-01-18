package simplicated.cc.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.*;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import Screens.basmannetjeeeScreen;

// Mixin to add a button to the title screen to switch to basmannetjeeeScreen.java (ignore the name I don't know what I was thinking)
@Mixin(TitleScreen.class)
public abstract class PauseMixin extends Screen {
    protected PauseMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "initWidgetsNormal")
    private void addCustomButton(int y, int spacingY, CallbackInfo ci) {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Screen 2"), (button) -> {
            MinecraftClient.getInstance().setScreen(new basmannetjeeeScreen());
        })
                .dimensions(this.width / 2 - 370 + 205, y, 50, 20) // Size and position of the button
                .build());
    }
}