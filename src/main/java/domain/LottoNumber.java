package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static constant.LottoConstant.*;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int number;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();;

    static {
        for (int number = MINIMUM_LOTTO_NUMBER; number <= MAXIMUM_LOTTO_NUMBER; number++) {
            lottoNumbers.put(number, new LottoNumber(number));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber getInstance(int number) {
        validateNumberRange(number);
        return lottoNumbers.get(number);
    }

    private static void validateNumberRange(int number) {
        if (number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE);
        }
    }

    public static LottoNumber createBonus(int inputBonusNumber, LottoTicketNumbers winningNumbers) {
        LottoNumber bonusNumber = LottoNumber.getInstance(inputBonusNumber);
        validateBonusNumber(winningNumbers, bonusNumber);
        return bonusNumber;
    }

    private static void validateBonusNumber(LottoTicketNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
    }

    public static List<LottoNumber> getNumbers() {
        return new ArrayList<>(lottoNumbers.values());
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber other) {
        return this.number - other.number;
    }
}
