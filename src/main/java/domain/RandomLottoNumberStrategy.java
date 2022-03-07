package domain;

import static constant.LottoConstant.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottoNumberStrategy implements LottoNumberStrategy {

    private final static List<LottoNumber> lottoNumbers = LottoNumber.getNumbers();

    @Override
    public List<LottoNumber> generate() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream()
                .limit(LOTTO_NUMBERS_SIZE)
                .collect(Collectors.toList());
    }
}
