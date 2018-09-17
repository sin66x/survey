function QuestionRate(id, questionId, average, count, nullCount, questionText) {

    this.id = id;
    this.questionId = questionId;
    this.average = average;
    this.count = count;
    this.nullCount = nullCount;
    this.questionText = questionText;

};


// Example add functionality to model
QuestionRate.prototype.scaleAverage = function () {
    return this.average * 10;
};