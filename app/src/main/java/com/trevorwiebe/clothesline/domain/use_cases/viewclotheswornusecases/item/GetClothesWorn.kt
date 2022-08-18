package com.trevorwiebe.clothesline.domain.use_cases.viewclotheswornusecases.item

import com.trevorwiebe.clothesline.domain.model.ClothesWornModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetClothesWorn(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(date: LocalDate): Flow<List<ClothesWornModel>>{
        return repository.getClothesWorn(date)
    }
}