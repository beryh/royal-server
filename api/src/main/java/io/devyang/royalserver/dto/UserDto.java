package io.devyang.royalserver.dto;

import java.sql.Timestamp;

import io.devyang.royalserver.exceptions.NotEnoughResourceException;
import lombok.*;

@Getter
@Setter
public class UserDto {
    private static final int SPIN_CHARGE_UNIT = 3;

    private final String username;
    private int rouletteLevel;
    private int remainSpin;
    private Timestamp latestSpinTimestamp;

    public UserDto(String username, int rouletteLevel, short remainSpin, Timestamp latestSpinTimestamp) {
        this.username = username;
        this.rouletteLevel = rouletteLevel;
        this.remainSpin = remainSpin;
        this.latestSpinTimestamp = latestSpinTimestamp;
    }

    public void deductSpinCount(int count) {
        Timestamp updatedTimestamp = this.updateSpinCount();

        if (count > this.remainSpin) {
            throw new NotEnoughResourceException("Not Enough Spin!");
        }

        this.remainSpin -= count;
        this.latestSpinTimestamp = updatedTimestamp;
    }

    private Timestamp updateSpinCount() {
        //FIXME: fix updating spin count and last spin time collectly
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        int seconds = (int) (currentTimestamp.getTime() - this.latestSpinTimestamp.getTime()) / 1000;
        this.remainSpin += (seconds / (60 * SPIN_CHARGE_UNIT));
        this.latestSpinTimestamp = currentTimestamp;

        return currentTimestamp;
    }
}