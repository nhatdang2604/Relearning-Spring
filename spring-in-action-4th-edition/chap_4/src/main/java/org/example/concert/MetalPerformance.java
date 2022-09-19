package org.example.concert;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MetalPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Yngwei Malmsteen is playing Jet to Jet");
    }
}
