/*
 * Copyright 2019 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:Suppress("unused")

package com.squareup.contour

import com.squareup.contour.SizeMode.Exact
import com.squareup.contour.solvers.XAxisSolver
import com.squareup.contour.solvers.YAxisSolver

interface LayoutContainer {
  val parent: Geometry
}

interface WidthOfOnlyContext : XAxisSolver, HasXPositionWithoutWidth
interface HeightOfOnlyContext : YAxisSolver, HasYPositionWithoutHeight

interface HasXPositionWithoutWidth {
  fun widthOf(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> XInt
  ): XAxisSolver

  fun widthOfFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> XFloat
  ): XAxisSolver
}

interface HasAbsoluteXPositionWithoutWidth : HasXPositionWithoutWidth

interface HasRelativeXPositionWithoutWidth : HasXPositionWithoutWidth

interface HasYPositionWithoutHeight {
  fun heightOf(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> YInt
  ): YAxisSolver

  fun heightOfFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> YFloat
  ): YAxisSolver
}

interface HasLeft : XAxisSolver, HasAbsoluteXPositionWithoutWidth {
  fun rightTo(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> LeftRightCompatibleXInt
  ): XAxisSolver

  fun rightToFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> LeftRightCompatibleXFloat
  ): XAxisSolver
}

interface HasStart : XAxisSolver, HasRelativeXPositionWithoutWidth {
  fun endTo(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> StartEndCompatibleXInt
  ): XAxisSolver

  fun endToFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> StartEndCompatibleXFloat
  ): XAxisSolver
}

interface HasRight : XAxisSolver, HasAbsoluteXPositionWithoutWidth {
  fun leftTo(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> LeftRightCompatibleXInt
  ): XAxisSolver

  fun leftToFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> LeftRightCompatibleXFloat
  ): XAxisSolver
}

interface HasEnd : XAxisSolver, HasRelativeXPositionWithoutWidth {
  fun startTo(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> StartEndCompatibleXInt
  ): XAxisSolver

  fun startToFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> StartEndCompatibleXFloat
  ): XAxisSolver
}

interface HasTop : YAxisSolver, HasYPositionWithoutHeight {
  fun bottomTo(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> YInt
  ): YAxisSolver

  fun bottomToFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> YFloat
  ): YAxisSolver
}

interface HasBottom : YAxisSolver, HasYPositionWithoutHeight {
  fun topTo(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> YInt
  ): YAxisSolver

  fun topToFloat(
    mode: SizeMode = Exact,
    provider: LayoutContainer.() -> YFloat
  ): YAxisSolver
}
