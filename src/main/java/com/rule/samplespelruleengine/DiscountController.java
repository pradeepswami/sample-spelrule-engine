package com.rule.samplespelruleengine;

import javax.annotation.PostConstruct;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiscountController {

	private Expression discountRule;

	@RequestMapping("/discount")
	public Float getDiscount(Order order) {
		Float value = discountRule.getValue(order, Float.class);
		return value;

	}

	@PostConstruct
	public void init() {
		SpelParserConfiguration config = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, this.getClass()
				.getClassLoader());
		SpelExpressionParser parser = new SpelExpressionParser(config);

		discountRule = parser
				.parseExpression("(type.equals('internet') and items.length > 2 )? 20 : (items.length > 4 ? 15 : 5)");
	}
}
