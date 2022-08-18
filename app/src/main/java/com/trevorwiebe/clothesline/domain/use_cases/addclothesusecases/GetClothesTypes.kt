package com.trevorwiebe.clothesline.domain.use_cases.addclothesusecases

import android.util.Log
import com.trevorwiebe.clothesline.domain.model.ClothesTypeModel
import com.trevorwiebe.clothesline.domain.repository.ClothesLineRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class GetClothesTypes(
    private val repository: ClothesLineRepository
) {
    operator fun invoke(): Flow<List<ClothesTypeModel>> {
        return repository.getClothesTypes()
    }
}