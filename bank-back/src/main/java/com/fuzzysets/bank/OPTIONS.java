package com.fuzzysets.bank;

public enum OPTIONS {
    target, // от 0 (сохранить деньги от инфляции) до 10 (максимизация прибыли)
    months, // Срок в месяцах
    risk, // Уровень риска от 0 (очень низкий) до 10 (очень высокий)
    percent, // Предлагаемый процент по вкладу

    depositRecommendation // Рекомендация по вкладу от 0 (совсем не рекомендуется) до 100 (настоятельно рекомендуется)
}

/*
скорый {
    target = 0,
    months = 1,
    risk = 0,
    percent = 10
},
весенний {
    target = 4,
    months = 3,
    risk = 4,
    percent =  14
},
годовой {
    target = 7,
    months = 12,
    risk = 8,
    percent =  18
},
сохранный {
    target = 8,
    months = 18,
    risk = 8,
    percent = 25
},
дивидендный {
    target = 10,
    months = 36,
    risk = 10,
    percent =  30
}
*/
