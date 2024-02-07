
## CONSUMER CONTROLLER

### /user/register

    -Kullanıcıların kayıt işlemini sağlar
### /user/login
    -Kullanıcıların email ve şifre ile girişini sağlar
 
## STUDENT CONTROLLER
 
### /student/changeStudentInf
    -Giriş yapan öğrenciden alınan token değeri ile 
     öğrencinin email ve telefon numarasını güncelleyebiliriz
### /student/findStudentSurvey
    -Giriş yapan öğrenciden alınan token değeri ile 
     öğrencinin kayıtlı oldığı anketlere ulaşılır.
### /student/findQuestionBySurvey
    -Giriş yapan öğrenciden alınan token değeri ve 
    student/findStudentSurvey alınan surveyId ile
    ankettteki soruları getirir.
### /student/answerQuestion
    -Giriş yapan öğrenciden alınan token değeri ve 
    student/findStudentSurvey alınan surveyId 
    student/findQuestionBySurvey alınan questionId ile
    soruya vermek istediğiniz cevap yazılarak cevaplanır.
## MANAGER CONTROLLER

### /manager/findSurveyByTeacher
    -Giriş yapan yöneticiden alınan token değeri ile
    öğretmenlerin açtığı anketleri görebiliriz
### /manager/findAllSurvey
    -Giriş yapan yöneticiden alınan token değeri ile
    bütün anketler görülebilir
### /manager/findAllTeacher
    -Giriş yapan yöneticiden alınan token değeri ile 
    tüm öğretmenler getirilir 
### /manager/findAllStudent
    -Giriş yapan yöneticiden alınan token değeri ile 
    tüm öğrencler getirilir

### /manager/addStudent
### /manager/addManager
### /manager/addTeacher

    -Bu 3 alanda giriş yapan yöneticiden alınan token
    değeri ile yönetici,öğretmen,öğrenci eklenabilir 
### /manager/findAnswersBySurveyAndQuestion

    -/manager/findAllSurvey'den anket listesinden hangi anket
    soruları ve cevapları isteniyorsa o anketin id'si ve token verileri girilerek
    sorular ve verilen cevaplar listelenir
### /manager/changeTeacherInfo
### /manager/changeStudentInfo
    -Giriş yapan yöneticiden alınan token değeri ile 
    /manager/findAllTeacher veya /manager/findAllStudent'dan alınan 
    Id ile öğretmen ve öğrenci bilgileri güncellenebilir.

## TEACHER CONTROLLER

### /teacher/findAllStudent
     -Giriş yapan öğretmenden alınan token değeri ile
    tüm öğrencileri getirir.
### /teacher/findAllStudent
    -Giriş yapan öğretmenden alınan token değeri ile 
    havuzdaki tüm soruları getirir.
### /teacher/findMySurvey
     -Giriş yapan öğretmenden alınan token değeri ile 
     öğretmenin kendine ait anketleri getirir.
### /teacher/findMyQuestion
    -Giriş yapan öğretmenden alınan token değeri ile 
    öğretmenin kendine ait sorularını getirir.
### /teacher/findByAnswerBySurveyAndQuestion
    -Giriş yapan öğretmenden alınan token değeri ve
    /teacher/findMySurvey' den alınan id ile cevaplar 
    bulunur
## /teacher/addSurvay
     -Giriş yapan öğretmenden alınan token değeri ve
     anket adı yazılarak anket eklenir.
## /teacher/addQuestionToPool
     -Giriş yapan öğretmenden alınan token değeri ve
     soru yazılarak havuza soru eklenir.
## /teacher/getQuestionBySurvey
    -Giriş yapan öğretmenden alınan token değeri ve
    /teacher/findMySurvey' den alınan id ile sorular
    bulunur.
### /teacher/addQuestionToSurvey
    /teacher/FindMySurvey kısmında öğretmenin kendisine ait anketlerden anket id'si alınır 
    /teacher/FindAllQuestions veya  /teacher/FindMyQuestions alanlarından sorunun tamamı alınır .
    ve token verisi girilerek ankete soru eklenebilir .
### /teacher/add_student_to_survey
    /teacher/FindMySurvey kısmında öğretmenin kendisine ait anketlerden anket id'si alınır
    /teacher/FindAllStudent kısmında eklenmek istenen öğrenciler seçilir
    ve token verisi girilerek ankete öğrenci eklenebilir.
### /teacher/get_answers_by_survey_and_question
    /teacher/FindMySurvey kısmında öğretmenin kendisine ait anketlerden anket id'si alınır
    token ve id bilgisi girilerek sorular ve cevapları görüntülenebilir .
### /teacher/delete_survey
    /teacher/FindMySurvey ile anket id si ve 
    token verisi girilerek silinmek istenen anket silinebilir.
### /teacher/delete_student
    /teacher/FindMySurvey ile istenilen anketin id si
    /teacher/FindStudentBySurvey ile silinmek istenen öğrencilerin listesi
    ve token verileri girilerek öğrenciler silinir
### /teacher/delete_question
    /teacher/FindMySurvey ile istenilen anketin id si
    /teacher/FindQuestionsBySurvey den istenilen sorular
    ve token verileri ile sorular silinebilir
    