create view roozaneh.v_rate_per_question as
select SUM(cast (r.answer as integer)) sm,r.question_id,count(*) cnt,SUM(cast (r.answer as float))/count(*) avg,null_answers.cnt null_cnt from roozaneh.results r
	join roozaneh.questions q
		on q.id = r.question_id
	left join (
		select count(*) cnt,rr.question_id from roozaneh.results rr
			join roozaneh.questions qq
				on qq.id = rr.question_id
			where qq.type='AGR'
			and rr.answer is null
				group by rr.question_id
		) null_answers
		on q.id = null_answers.question_id

	where q.type='AGR'
	and r.answer is not null
		group by r.question_id,null_answers.cnt;

-------------------------

create view roozaneh.v_rate_per_part as
select AVG(rate.avg),(COALESCE(SUM(cnt),0)/(COALESCE(SUM(cnt),0)+COALESCE(SUM(null_cnt),0)))*100 ANSWERED_PERCENTAGE,q.survey_part_id from roozaneh.v_rate_per_question rate
	join roozaneh.questions q
		on q.id = rate.question_id
	group by q.survey_part_id