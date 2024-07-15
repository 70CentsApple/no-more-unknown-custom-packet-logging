package net.apple70cents.no_more_unknown_custom_packet_logging.mixins;

import net.minecraft.client.network.ClientConfigurationNetworkHandler;
import net.minecraft.network.packet.CustomPayload;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientConfigurationNetworkHandler.class)
public abstract class MixinClientConfigurationNetworkHandler {
    @Inject(method = "handleCustomPayload", at = @At(value = "HEAD"), cancellable = true)
    private void onWarnOnUnknownPayload(CustomPayload payload, CallbackInfo ci) {
        ci.cancel();
    }
}
