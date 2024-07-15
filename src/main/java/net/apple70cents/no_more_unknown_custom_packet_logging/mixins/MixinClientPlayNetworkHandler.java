package net.apple70cents.no_more_unknown_custom_packet_logging.mixins;

import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class MixinClientPlayNetworkHandler {
    @Inject(method = "warnOnUnknownPayload", at = @At(value = "HEAD"), cancellable = true)
    private void onWarnOnUnknownPayload(CustomPayload payload, CallbackInfo ci) {
        ci.cancel();
    }
}
